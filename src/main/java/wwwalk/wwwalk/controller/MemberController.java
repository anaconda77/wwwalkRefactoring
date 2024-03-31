package wwwalk.wwwalk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import wwwalk.wwwalk.dto.ErrorResponse;
import wwwalk.wwwalk.dto.ProfileDto;
import wwwalk.wwwalk.dto.SuccessResponse;
import wwwalk.wwwalk.email.EmailContentBuilder;
import wwwalk.wwwalk.entity.Member;
import wwwalk.wwwalk.exception.LoginException;
import wwwalk.wwwalk.exception.UserException;
import wwwalk.wwwalk.repository.MemberRepository;
import wwwalk.wwwalk.auth.JwtFilter;
import wwwalk.wwwalk.auth.TokenProvider;
import wwwalk.wwwalk.service.MemberService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/auth")
public class MemberController {

    @Autowired
    private final MemberService memberService;
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final TokenProvider tokenProvider;
    @Autowired
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    @ExceptionHandler(UserException.class)
    public ErrorResponse userExHandle(UserException e) {
        log.error("[userException] ex", e);
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "BAD_REQUEST", e.getMessage());
    }

    @ExceptionHandler(LoginException.class)
    public ErrorResponse loginExHandle(LoginException e) {
        log.error("[loginException] ex", e);
        return new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "UNAUTHORIZED", e.getMessage());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public SuccessResponse create(@RequestBody MemberJoinForm memberJoinForm) {
        memberService.join(memberJoinForm);
        return new SuccessResponse(HttpStatus.CREATED.value(), "CREATED", "Id Saved");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/verify")
    public SuccessResponse sendVerifyMail(@RequestParam String username) {
        Member findMember = memberService.getMemberByUsername(username);
        memberService.sendVerificationEmail(findMember);
        return new SuccessResponse(HttpStatus.CREATED.value(), "CREATED", "인증 메일을 전송하였습니다.");
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/verify/{key}")
    public SuccessResponse getVerify(@PathVariable String key) {
        memberService.verifyEmail(key);
        return new SuccessResponse(HttpStatus.OK.value(), "OK", "유저 인증이 완료되었습니다.");
    }


    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public SuccessResponse login(@RequestBody MemberJoinForm memberJoinForm) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(memberJoinForm.getUsername(), memberJoinForm.getPassword());
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.createToken(authentication);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);

        return new SuccessResponse(HttpStatus.OK.value(), "ACCEPTED", jwt);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/profile")
    public ProfileDto showProfile() {

        String username = memberService.getUsernameFromAuthentication();
        return memberService.getUserProfile(username);
    }

}
