package wwwalk.wwwalk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wwwalk.wwwalk.dto.ErrorResponse;
import wwwalk.wwwalk.dto.ProfileDto;
import wwwalk.wwwalk.dto.SuccessResponse;
import wwwalk.wwwalk.dto.ResponseDto;
import wwwalk.wwwalk.entity.User;
import wwwalk.wwwalk.exception.LoginException;
import wwwalk.wwwalk.exception.UserException;
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
    public SuccessResponse create(@RequestBody UserJoinForm userJoinForm) {
        User user = new User(userJoinForm);
        userService.join(user);
        return new SuccessResponse(HttpStatus.CREATED.value(), "CREATED", "Id Saved");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/login")
    public SuccessResponse login(@RequestBody UserJoinForm userJoinForm) {
        String loginUuid = userService.login(userJoinForm.getId(), userJoinForm.getPassword());
        return new SuccessResponse(HttpStatus.ACCEPTED.value(), "ACCEPTED", loginUuid);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/profile")
    public ProfileDto showProfile(@RequestParam String uuid) {
        User findUser = userService.getUserInfo(uuid);
        return new ProfileDto( findUser.getName(), findUser.getImageUrl(), findUser.getDistance(), null);
    }


}
