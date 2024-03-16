package wwwalk.wwwalk.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RoutePointForm {
    private String uuid;
    @JsonProperty(value = "route_id")
    private String routeId;
    @JsonProperty(value = "lon")
    private double longitude;
    @JsonProperty(value = "lat")
    private double latitude;
}
