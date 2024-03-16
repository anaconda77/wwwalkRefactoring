package wwwalk.wwwalk.dto;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class RouteDto {

    String routeId;
    String name;
    List<PinDto> pins;
    Integer distance;
    LocalDateTime duration;

    public RouteDto(String routeId, String name, List<PinDto> pins) {
        this.routeId = routeId;
        this.name = name;
        this.pins = pins;
    }

//    public RouteDto(String routeId, String name, List<PinDto> pins, Integer distance, LocalDateTime duration) {
//        this.routeId = routeId;
//        this.name = name;
//        this.pins = pins;
//        this.distance = distance;
//        this.duration = duration;
//    }
}
