package wwwalk.wwwalk.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class MemberJoinForm {

    private String username;
    private String password;
    private String name;
    @JsonProperty(value = "image_url")
    private String imageUrl;

    public MemberJoinForm(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
