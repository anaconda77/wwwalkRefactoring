package wwwalk.wwwalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwwalk.wwwalk.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
