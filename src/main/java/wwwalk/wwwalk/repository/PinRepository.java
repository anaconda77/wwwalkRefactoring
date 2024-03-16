package wwwalk.wwwalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwwalk.wwwalk.entity.Pin;

public interface PinRepository extends JpaRepository<Pin, Long> {
}
