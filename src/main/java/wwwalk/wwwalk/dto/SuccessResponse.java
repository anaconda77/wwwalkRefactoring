package wwwalk.wwwalk.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResponse {
    private int status;
    private String httpStatus;
    private String message;

}
