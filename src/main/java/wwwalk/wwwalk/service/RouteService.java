package wwwalk.wwwalk.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wwwalk.wwwalk.controller.RouteEditForm;
import wwwalk.wwwalk.controller.RoutePointForm;
import wwwalk.wwwalk.entity.Pin;
import wwwalk.wwwalk.entity.Point;
import wwwalk.wwwalk.entity.Route;
import wwwalk.wwwalk.entity.State;
import wwwalk.wwwalk.repository.RouteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class RouteService {

    @Autowired
    private final RouteRepository routeRepository;
    @Autowired
    private final SessionManager sessionManager;


    public String doLike(String uuid, Long routeId) {
        String userId = sessionManager.getId(uuid);
        String result = routeRepository.manageLike(userId, routeId);
        if(result.equals("like")) {
            return "1";
        }
        else if(result.equals("unLike")) {
            return "0";
        }
        else {
            throw new IllegalStateException("작업 중 오류가 발생하였습니다.");
        }
    }

    public void addPoint(RoutePointForm form) {
        String userId = sessionManager.getId(form.getUuid());
        Route findRoute = routeRepository.findById(Long.valueOf(form.getRouteId()));
        if(!(findRoute.getUser().getId()).equals(userId)) {
            throw new IllegalStateException();
        }
        Point point = new Point(form.getLongitude(), form.getLatitude(), LocalDateTime.now(), findRoute);
        routeRepository.createPoint(point);
    }

    public void modifyRoute(RouteEditForm form) {
        String userId = sessionManager.getId(form.getUuid());
        Route modifiedRoute = new Route(Long.valueOf(form.getRouteId()), form.getName(), State.valueOf(form.getSecurity()));

        List<Pin> newPins = form.getNewPins().stream()
        .map(p -> new Pin(p.getMemo(), p.getImageUrl(),
                modifiedRoute, routeRepository.findPointById(Long.valueOf(p.getPointId()))))
                .collect(Collectors.toList());

        List<Long> delPins = form.getDelPins().stream()
                .map(p -> Long.valueOf(p.getPinId()))
                .collect(Collectors.toList());
        routeRepository.updateRouteAndPins(userId, modifiedRoute,
               newPins, delPins);
    }
}
