package wwwalk.wwwalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwwalk.wwwalk.entity.Point;

public interface PointRepository extends JpaRepository<Point,Long> {
}
