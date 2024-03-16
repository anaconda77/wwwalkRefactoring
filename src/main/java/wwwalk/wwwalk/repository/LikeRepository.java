package wwwalk.wwwalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwwalk.wwwalk.entity.Like;

public interface LikeRepository extends JpaRepository<Like,Long> {
}
