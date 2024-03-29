package wwwalk.wwwalk.dto;

import lombok.Data;
import wwwalk.wwwalk.entity.Member;

@Data
public class MemberDto {

    private String id;
    private String password;
    private String name;
    private String imageUrl;

    public MemberDto() {
    }

    public MemberDto(Member member) {
        this.id = member.getId().toString();
        this.password = member.getPassword();
        this.name = member.getUsername();
        this.imageUrl = member.getImageUrl();
    }
}
