package wwwalk.wwwalk.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SuccessResponseDto extends ResponseDto{
    private String successMessage;


    public SuccessResponseDto(int status, HttpStatus httpStatus, String message) {
        super(status, httpStatus);
        this.successMessage = message;
    }
}
