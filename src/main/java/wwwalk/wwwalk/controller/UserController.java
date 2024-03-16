package wwwalk.wwwalk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wwwalk.wwwalk.dto.ErrorResponseDto;
import wwwalk.wwwalk.dto.ProfileDto;
import wwwalk.wwwalk.dto.SuccessResponseDto;
import wwwalk.wwwalk.dto.ResponseDto;
import wwwalk.wwwalk.entity.User;
import wwwalk.wwwalk.repository.UserRepository;
import wwwalk.wwwalk.service.UserService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private final UserService userService;
    @Autowired
    private final UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseDto create(@RequestBody UserJoinForm userJoinForm) {
        int status;
        HttpStatus httpStatus;

        try {
            User user = new User(userJoinForm);
            userService.join(user);

            status = HttpStatus.CREATED.value();
            httpStatus = HttpStatus.CREATED;
            return new SuccessResponseDto(status, httpStatus, "Id Saved");
        }
        catch (RuntimeException e) {
            log.info("e.message= {}", e.getMessage());
            status = HttpStatus.BAD_REQUEST.value();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ErrorResponseDto(status, httpStatus, "Id Duplicate Error");
        }

    }

    @PostMapping("/login")
    public ResponseDto login(@RequestBody UserJoinForm userJoinForm) {
        int status;
        HttpStatus httpStatus;

        try {
            String loginUuid = userService.login(userJoinForm.getId(), userJoinForm.getPassword());
            status = HttpStatus.ACCEPTED.value();
            httpStatus = HttpStatus.ACCEPTED;
            return new SuccessResponseDto(status, httpStatus, loginUuid);
        }
        catch (RuntimeException e) {
            log.info("로그인 실패, e.message= {}", e.getMessage());
            status = HttpStatus.UNAUTHORIZED.value();
            httpStatus = HttpStatus.UNAUTHORIZED;
            return new ErrorResponseDto(status, httpStatus, "User Id No Exist");
        }

    }

    @GetMapping("/profile")
    public ResponseDto showProfile(@RequestParam String uuid) {
        int status;
        HttpStatus httpStatus;
        try {
            User findUser = userRepository.findById(userService.convertUuidToId(uuid)).get();
            status = HttpStatus.ACCEPTED.value();
            httpStatus = HttpStatus.ACCEPTED;
            return new ProfileDto(status, httpStatus, findUser.getName(), findUser.getImageUrl(), findUser.getDistance(), null);
        }
        catch (RuntimeException e) {
            log.info("e.message= {}", e.getMessage());
            status = HttpStatus.BAD_REQUEST.value();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseDto(status, httpStatus);
        }
    }



}
