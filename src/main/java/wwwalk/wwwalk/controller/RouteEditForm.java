package wwwalk.wwwalk.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class RouteEditForm {

    private String uuid;
    @JsonProperty(value = "route_id")
    private String routeId;
    private String name;
    private String security;
    private List<String> tags;
    @JsonProperty(value = "del_tags")
    private List<String> delTags;
    @JsonProperty(value = "pins_new")
    private List<PinAddForm> newPins;
    @JsonProperty(value = "pins_delete")
    private List<PinDeleteForm> delPins;

    @Getter
    public static class PinDeleteForm {
        @JsonProperty(value = "pin_id")
        private String pinId;
        
    }

    @Getter
    public static class PinAddForm {
        @JsonProperty(value = "point_id")
        private String pointId;
        @JsonProperty(value = "image_url")
        private String imageUrl;
        private String memo;
        private String address;
        @JsonProperty(value = "address_name")
        private String addressName;
    }

    public RouteEditForm(String uuid, String routeId, String name, String security, List<String> tags, List<String> delTags, List<PinAddForm> newPins, List<PinDeleteForm> delPins) {
        this.uuid = uuid;
        this.routeId = routeId;
        this.name = name;
        this.security = security;
        this.tags = tags;
        this.delTags = delTags;
        this.newPins = newPins;
        this.delPins = delPins;
    }
}
