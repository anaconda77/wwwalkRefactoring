package wwwalk.wwwalk.dto;

import lombok.Data;
import wwwalk.wwwalk.entity.User;

@Data
public class UserDto {

    private String id;
    private String password;
    private String name;
    private String imageUrl;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
        this.name = user.getName();
        this.imageUrl = user.getImageUrl();
    }
}
