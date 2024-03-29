package wwwalk.wwwalk.repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wwwalk.wwwalk.dto.PinDto;
import wwwalk.wwwalk.dto.RouteDto;
import wwwalk.wwwalk.entity.*;
import wwwalk.wwwalk.service.SessionManager;

import java.util.List;
import java.util.stream.Collectors;

import static wwwalk.wwwalk.entity.QFavorite.favorite;
import static wwwalk.wwwalk.entity.QPin.pin;
import static wwwalk.wwwalk.entity.QPoint.point;
import static wwwalk.wwwalk.entity.QRoute.route;
@Repository
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RouteRepository {

    @Autowired
    private final JPAQueryFactory queryFactory;
    @Autowired
    private final EntityManager em;
    @Autowired
    private final SessionManager sessionManager;

    public Route findById(Long routeId) {
        return em.find(Route.class, routeId);
    }

    public Route findByName(String name) {
        return em.createQuery("select r from Route r where r.name = :name", Route.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public void createPoint(Point point) {
        em.persist(point);
    }

    public Point findPointById(Long pointId) {
        return em.find(Point.class, pointId);
    }

    public void updateRouteAndPins(String userId, Route modifyRoute, List<Pin> newPins, List<Long> delPins) {
        em.flush(); em.clear();

        Route originRoute = findById(modifyRoute.getId());
        originRoute.setName(modifyRoute.getName());
        originRoute.setSecurity(modifyRoute.getSecurity());

        for (Pin pin : newPins) {
            em.persist(pin);
        }

        for (Long id : delPins) {
            em.createQuery("delete from Pin p where p.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
        }

    }


    public List<RouteDto> findAllRoutesAndPins(String uuid) {

        String userId = sessionManager.getId(uuid);

        List<Tuple> routes = queryFactory
                .select(
                        route.id,
                        route.name
                )
                .from(route)
                .where(route.member.username.eq(userId))
                .fetch();

        List<Pin> allPins = findAllPins();

        return routes.stream()
                .map(r -> new RouteDto(r.get(route.id).toString(), r.get(route.name),
                        makePinDto(r, allPins)
                ))
                .collect(Collectors.toList());
    }

    public List<RouteDto> findFavorites(String uuid) {

        String userId = sessionManager.getId(uuid);

//        if(userId.isEmpty()) {
//            throw new IllegalStateException("다시 로그인 해주세요.");
//        }

        List<Tuple> routes = queryFactory
                .select(
                        route.id,
                        route.name
                )
                .from(favorite)
                .join(favorite.route, route)
                .where(route.member.username.eq(userId))
                .fetch();

        List<Pin> allPins = findAllPins();

        return routes.stream()
                .map(r -> new RouteDto(r.get(route.id).toString(), r.get(route.name),
                        makePinDto(r, allPins)
                ))
                .collect(Collectors.toList());
    }

    public String manageLike(String userId, Long routeId) {
        Member member = em.find(Member.class, userId);
        Route route = em.find(Route.class, routeId);
        List<Like> result = em.createQuery("select l from Like l " +
                        "where l.user.id= :userId and l.route.id= :routeId", Like.class)
                .setParameter("userId", userId)
                .setParameter("routeId", routeId)
                .getResultList();
        if(result.isEmpty()) {
            Like like = new Like(member, route);
            em.persist(like);
            return "like";
        }
        else {
            Like like = result.get(0);
            em.remove(like);
            return "unLike";
        }
    }

    private static List<PinDto> makePinDto(Tuple r, List<Pin> allPins) {

        return allPins.stream()
                .filter(p -> p.getRoute().getId().equals(r.get(route.id)))
                .map(p -> new PinDto(p.getPoint().getId(), p.getId(),
                        p.getImageUrl(), p.getMemo(), p.getPoint().getPointX(), p.getPoint().getPointY()))
                .collect(Collectors.toList());
    }

    private List<Pin> findAllPins() {
        return queryFactory
                .selectFrom(pin)
                .join(pin.point, point).fetchJoin()
                .fetch();
    }

}
