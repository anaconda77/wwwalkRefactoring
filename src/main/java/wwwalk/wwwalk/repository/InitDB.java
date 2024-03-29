package wwwalk.wwwalk.repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wwwalk.wwwalk.entity.*;

import java.time.LocalDateTime;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init();
    }

    @ComponentScan
    static class InitService {

        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void init() {
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Member memberA = new Member("id1", passwordEncoder.encode("1234"), "kim", "url1", 0, State.PUBLIC, LocalDateTime.now(), LocalDateTime.now());
            Member memberB = new Member("id2", passwordEncoder.encode("1234"), "shin", "url2", 0, State.PUBLIC, LocalDateTime.now(), LocalDateTime.now());

            Route routeA = new Route("route1", 0.0, 0.0, 10.0, 10.0, LocalDateTime.now()
                    ,1000, "musicUrl", LocalDateTime.now(), State.PUBLIC, memberA);
            Route routeB = new Route("route2", 2.0, 2.0, 12.0, 12.0, LocalDateTime.now()
                    ,1100, "musicUrl", LocalDateTime.now(), State.PUBLIC, memberA);
            Favorite fvrA = new Favorite(memberA, routeA);
            Favorite fvrB = new Favorite(memberA, routeB);
            Point pointA = new Point(0.0, 0.0, LocalDateTime.now(), routeA);
            Point pointB = new Point(1.0, 1.0, LocalDateTime.now(), routeB);
            Point pointC = new Point(2.0, 2.0, LocalDateTime.now(), routeA);
            Point pointD = new Point(3.0, 3.0, LocalDateTime.now(), routeA);
            Pin pinA = new Pin("memo", "imageUrl", routeA, pointA);
            Pin pinB = new Pin("memo", "imageUrl", routeB, pointB);

            em.persist(memberA); em.persist(memberB);
            em.persist(routeA); em.persist(routeB);
            em.persist(fvrA); em.persist(fvrB);
            em.persist(pointA); em.persist(pointB); em.persist(pointC); em.persist(pointD);
            em.persist(pinA); em.persist(pinB);
        }

    }
}
