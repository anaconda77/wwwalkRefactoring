package wwwalk.wwwalk.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wwwalk.wwwalk.controller.UserJoinForm;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "userinfo")
public class User {

    @Id @Column(name = "user_id")
    private String id;
    private String password;
    private String name;
    @Column(name = "image_url")
    private String imageUrl;
    private Integer distance;
    private State state;

    public User(UserJoinForm userJoinForm) {
        this.id = userJoinForm.getId();
        this.password = userJoinForm.getPassword();
        this.name = userJoinForm.getName();
        this.imageUrl = userJoinForm.getImageUrl();
        this.distance = 0;
        this.state = State.PUBLIC;
    }

    public User(String id, String password, String name, String imageUrl, State state) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.imageUrl = imageUrl;
        this.distance = 0;
        this.state = state;
    }

    public void setPassword(String hashedPw) {
        this.password = hashedPw;
    }
}
