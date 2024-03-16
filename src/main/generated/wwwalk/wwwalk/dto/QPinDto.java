package wwwalk.wwwalk.dto;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.ConstructorExpression;
import javax.annotation.processing.Generated;

/**
 * wwwalk.wwwalk.dto.QPinDto is a Querydsl Projection type for PinDto
 */
@Generated("com.querydsl.codegen.DefaultProjectionSerializer")
public class QPinDto extends ConstructorExpression<PinDto> {

    private static final long serialVersionUID = -231248007L;

    public QPinDto(com.querydsl.core.types.Expression<Long> pointId, com.querydsl.core.types.Expression<Long> pinId, com.querydsl.core.types.Expression<String> imageUrl, com.querydsl.core.types.Expression<String> memo, com.querydsl.core.types.Expression<Double> pointX, com.querydsl.core.types.Expression<Double> pointY) {
        super(PinDto.class, new Class<?>[]{long.class, long.class, String.class, String.class, double.class, double.class}, pointId, pinId, imageUrl, memo, pointX, pointY);
    }

}

