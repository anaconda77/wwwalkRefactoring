package wwwalk.wwwalk.repository;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import wwwalk.wwwalk.entity.*;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitData {

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
            User userA = new User("id1", loginHashing("1234"), "kim", "url1", State.PUBLIC);
            User userB = new User("id2", loginHashing("1234"), "shin", "url2", State.PUBLIC);

            Route routeA = new Route("route1", 0.0, 0.0, 10.0, 10.0, LocalDateTime.now()
                    ,1000, "musicUrl", LocalDateTime.now(), State.PUBLIC, userA);
            Route routeB = new Route("route2", 2.0, 2.0, 12.0, 12.0, LocalDateTime.now()
                    ,1100, "musicUrl", LocalDateTime.now(), State.PUBLIC, userA);
            Favorite fvrA = new Favorite(userA, routeA);
            Favorite fvrB = new Favorite(userA, routeB);
            Point pointA = new Point(0.0, 0.0, LocalDateTime.now(), routeA);
            Point pointB = new Point(1.0, 1.0, LocalDateTime.now(), routeB);
            Point pointC = new Point(2.0, 2.0, LocalDateTime.now(), routeA);
            Point pointD = new Point(3.0, 3.0, LocalDateTime.now(), routeA);
            Pin pinA = new Pin("memo", "imageUrl", routeA, pointA);
            Pin pinB = new Pin("memo", "imageUrl", routeB, pointB);

            em.persist(userA); em.persist(userB);
            em.persist(routeA); em.persist(routeB);
            em.persist(fvrA); em.persist(fvrB);
            em.persist(pointA); em.persist(pointB); em.persist(pointC); em.persist(pointD);
            em.persist(pinA); em.persist(pinB);
        }

        private String loginHashing(String before) {
            String sha256 = "";
            try{
                MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
                mdSHA256.update(before.getBytes("UTF-8"));
                byte[] sha256Hash = mdSHA256.digest();

                StringBuffer hexSHA256hash = new StringBuffer();
                for(byte b : sha256Hash){
                    String hexString = String.format("%02x",b);
                    hexSHA256hash.append(hexString);
                }
                sha256 = hexSHA256hash.toString();
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
            return sha256;
        }
    }
}
