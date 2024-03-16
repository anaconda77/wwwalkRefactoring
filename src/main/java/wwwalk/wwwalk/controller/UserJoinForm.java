package wwwalk.wwwalk.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserJoinForm {

    private String id;
    private String password;
    private String name;
    @JsonProperty(value = "image_url")
    private String imageUrl;
}
