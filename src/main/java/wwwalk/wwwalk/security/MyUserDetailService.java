package wwwalk.wwwalk.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wwwalk.wwwalk.entity.Member;
import wwwalk.wwwalk.exception.LoginException;
import wwwalk.wwwalk.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new LoginException("User Id No Exist"));
        log.info("member 권한={}", member.getRole().toString());
        return new SecurityUser(member);
    }


}
