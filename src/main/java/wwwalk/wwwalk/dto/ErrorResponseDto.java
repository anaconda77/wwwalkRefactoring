package wwwalk.wwwalk.dto;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ErrorResponseDto extends ResponseDto{
    private String errorMessage;

    public ErrorResponseDto(int status, HttpStatus httpStatus, String message) {
        super(status, httpStatus);
        this.errorMessage = message;
    }
}
