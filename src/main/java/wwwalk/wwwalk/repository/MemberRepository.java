package wwwalk.wwwalk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wwwalk.wwwalk.entity.Member;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);


}
