package wwwalk.wwwalk.dto;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ResponseDto {
    private int status;
    private HttpStatus httpStatus;

    public ResponseDto(int status, HttpStatus httpStatus) {
        this.status = status;
        this.httpStatus = httpStatus;
    }
}
