package wwwalk.wwwalk.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProfileDto extends ResponseDto {

    private String userName;
    private String photoUrl;
    private int sumDistance;
    private Integer walkCount;


    public ProfileDto(int status, HttpStatus httpStatus,
                      String userName, String photoUrl, int sumDistance, Integer walkCount) {
        super(status, httpStatus);
        this.userName = userName;
        this.photoUrl = photoUrl;
        this.sumDistance = sumDistance;
        this.walkCount = walkCount;
    }

}
