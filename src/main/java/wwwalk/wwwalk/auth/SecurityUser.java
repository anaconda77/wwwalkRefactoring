package wwwalk.wwwalk.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import wwwalk.wwwalk.entity.Member;

import java.util.Collection;

@Slf4j
@Getter
@Setter
public class SecurityUser extends User {

    private Member member;

    public SecurityUser(Member member) {
        super(member.getUsername(), member.getPassword(), AuthorityUtils.createAuthorityList("ROLE_" + member.getRole().toString()));
        this.member = member;
    }
}
