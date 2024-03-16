package wwwalk.wwwalk.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RouteLikeForm {
    private String uuid;
    @JsonProperty(value = "route_id")
    private String routeId;

}
