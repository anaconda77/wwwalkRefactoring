package wwwalk.wwwalk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wwwalk.wwwalk.dto.ErrorResponse;
import wwwalk.wwwalk.dto.MemberDto;
import wwwalk.wwwalk.dto.ProfileDto;
import wwwalk.wwwalk.entity.Member;
import wwwalk.wwwalk.exception.UserException;
import wwwalk.wwwalk.repository.MemberRepository;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final SessionManager sessionManager;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public void join(Member member) {
        validateDuplicateMember(member.getUsername());
        member.setPassword(passwordEncoder.encode(member.getPassword()));

        memberRepository.save(member);
    }

//    public String loginUuid(String username, String password) {
//        String uuid = UUID.randomUUID().toString();
//        sessionManager.putId( uuid, username);
//
//        return uuid;
//    }

    public String getUsernameFromAuthentication() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            throw new UserException("Security Context에 인증 정보가 없습니다.");
        }

        String username = authentication.getName();
        if(username == null) {
            throw new UserException("No Exist User");
        }
        //log.info("Claims 추출 정보={}",username);
        return username;
    }
    public ProfileDto getUserProfile(String username) {
        Member findMember = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UserException("Fail To Find User"));

        return new ProfileDto(findMember.getUsername(), findMember.getImageUrl(), findMember.getDistance(), null);
    }



//    public String convertUuidToUsername(String uuid) {
//        return sessionManager.getId(uuid);
//    }



    private void validateDuplicateMember(String username) {
        Member findMember = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UserException("Id Duplicate Error"));
    }

}
