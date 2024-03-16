package wwwalk.wwwalk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPoint is a Querydsl query type for Point
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPoint extends EntityPathBase<Point> {

    private static final long serialVersionUID = 992107525L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPoint point = new QPoint("point");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> pDate = createDateTime("pDate", java.time.LocalDateTime.class);

    public final NumberPath<Double> pointX = createNumber("pointX", Double.class);

    public final NumberPath<Double> pointY = createNumber("pointY", Double.class);

    public final QRoute route;

    public QPoint(String variable) {
        this(Point.class, forVariable(variable), INITS);
    }

    public QPoint(Path<? extends Point> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPoint(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPoint(PathMetadata metadata, PathInits inits) {
        this(Point.class, metadata, inits);
    }

    public QPoint(Class<? extends Point> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.route = inits.isInitialized("route") ? new QRoute(forProperty("route"), inits.get("route")) : null;
    }

}

