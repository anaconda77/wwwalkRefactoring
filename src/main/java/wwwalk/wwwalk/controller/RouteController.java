package wwwalk.wwwalk.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wwwalk.wwwalk.dto.*;
import wwwalk.wwwalk.exception.RouteException;
import wwwalk.wwwalk.exception.UserException;
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


    @ExceptionHandler(RouteException.class)
    public ErrorResponse routeExHandle(RouteException e) {
        log.error("[routeException] ex", e);
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "BAD_REQUEST", e.getMessage());
    }

    //즐겨찾기 목록 조회
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/favorite")
    public ResultResponse showFavorites(@RequestParam String uuid) {
        return new ResultResponse(routeRepository.findFavorites(uuid));
    }

    //산책 전체 정보 조회
    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping("/routeAllInfo")
    public ResultResponse showRouteInfo(@RequestParam String uuid) {
        return new ResultResponse(routeRepository.findAllRoutesAndPins(uuid));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/like")
    public SuccessResponse doLike(@RequestBody RouteLikeForm form) {
        String message = routeService.doLike(form.getUuid(), Long.valueOf(form.getRouteId()));
        return new SuccessResponse(HttpStatus.CREATED.value(), "CREATED", message);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addpoint")
    public SuccessResponse addPoint(@RequestBody RoutePointForm form) {
        routeService.addPoint(form);
        return new SuccessResponse(HttpStatus.CREATED.value(), "CREATED", "create point successfully");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/modify")
    public SuccessResponse modifyRouteInfo(@RequestBody RouteEditForm form) {
        routeService.modifyRoute(form);
        return new SuccessResponse(HttpStatus.CREATED.value(), "CREATED", "create point successfully");
    }
}
