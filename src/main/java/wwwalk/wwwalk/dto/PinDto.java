package wwwalk.wwwalk.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class PinDto {

    Long pointId;
    Long pinId;
    String imageUrl;
    String memo;
    double pointX;
    double pointY;

    @QueryProjection
    public PinDto(Long pointId, Long pinId, String imageUrl,
                  String memo, double pointX, double pointY) {
        this.pointId = pointId;
        this.pinId = pinId;
        this.imageUrl = imageUrl;
        this.memo = memo;
        this.pointX = pointX;
        this.pointY = pointY;
    }
}
