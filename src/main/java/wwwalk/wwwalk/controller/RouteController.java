package wwwalk.wwwalk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wwwalk.wwwalk.dto.*;
import wwwalk.wwwalk.repository.RouteRepository;
import wwwalk.wwwalk.service.RouteService;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/route")
public class RouteController {


    @Autowired
    private final RouteRepository routeRepository;
    @Autowired
    private final RouteService routeService;

    //즐겨찾기 목록 조회
    @GetMapping("/favorite")
    public ResultResponse showFavorites(@RequestParam String uuid) {
        return new ResultResponse(routeRepository.findFavorites(uuid));
    }

    //산책 전체 정보 조회
    @GetMapping("/routeAllInfo")
    public ResultResponse showRouteInfo(@RequestParam String uuid) {
        return new ResultResponse(routeRepository.findAllRoutesAndPins(uuid));
    }

    @PostMapping("/like")
    public ResponseDto doLike(@RequestBody RouteLikeForm form) {
        int status;
        HttpStatus httpStatus;

        try {
            String message = routeService.doLike(form.getUuid(), Long.valueOf(form.getRouteId()));
            status = HttpStatus.ACCEPTED.value();
            httpStatus = HttpStatus.ACCEPTED;
            return new SuccessResponseDto(status, httpStatus, message);
        } catch (RuntimeException e) {
            status = HttpStatus.UNAUTHORIZED.value();
            httpStatus = HttpStatus.UNAUTHORIZED;
            return new ErrorResponseDto(status, httpStatus, "error in like");
        }
    }

    @PostMapping("/addpoint")
    public ResponseDto addPoint(@RequestBody RoutePointForm form) {
        int status;
        HttpStatus httpStatus;

        try {
            routeService.addPoint(form);
            status = HttpStatus.ACCEPTED.value();
            httpStatus = HttpStatus.ACCEPTED;
            return new SuccessResponseDto(status, httpStatus, "create point successfully");
        } catch (RuntimeException e) {
            status = HttpStatus.UNAUTHORIZED.value();
            httpStatus = HttpStatus.UNAUTHORIZED;
            return new ErrorResponseDto(status, httpStatus, "error in creating point");
        }
    }

    @PostMapping("/modify")
    public ResponseDto modifyRouteInfo(@RequestBody RouteEditForm form) {
        int status;
        HttpStatus httpStatus;

        try {
            routeService.modifyRoute(form);
            status = HttpStatus.ACCEPTED.value();
            httpStatus = HttpStatus.ACCEPTED;
            return new SuccessResponseDto(status, httpStatus, "create point successfully");
        } catch (RuntimeException e) {
            status = HttpStatus.UNAUTHORIZED.value();
            httpStatus = HttpStatus.UNAUTHORIZED;
            return new ErrorResponseDto(status, httpStatus, "error in creating point");
        }
    }
}
