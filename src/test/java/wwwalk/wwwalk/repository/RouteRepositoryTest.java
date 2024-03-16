package wwwalk.wwwalk.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import wwwalk.wwwalk.entity.*;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@Slf4j
class RouteRepositoryTest {

    @Autowired EntityManager em;
    @Autowired RouteRepository routeRepository;

    @Test
    public void test() {
        User userA = new User("id3", "1234", "shin", "url2");
        Route route = new Route("route1", 0.0, 0.0, 0.0, 0.0, LocalDateTime.now()
                ,1000, "musicUrl", LocalDateTime.now(), "security", userA);
        Favorite fvr = new Favorite(userA, route);
        Point pointA = new Point(0.0, 0.0, LocalDateTime.now(), route);
        Pin pinA = new Pin("memo", "imageUrl", route, pointA);
        em.persist(userA);
        em.persist(route);
        em.persist(fvr);
        em.persist(pointA);
        em.persist(pinA);

        em.flush();
        em.clear();

        Route findRoute = routeRepository.findByName(route.getName());


    }

}