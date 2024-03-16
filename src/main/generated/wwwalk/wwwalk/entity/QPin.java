package wwwalk.wwwalk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPin is a Querydsl query type for Pin
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPin extends EntityPathBase<Pin> {

    private static final long serialVersionUID = -477179574L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPin pin = new QPin("pin");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath memo = createString("memo");

    public final QPoint point;

    public final QRoute route;

    public QPin(String variable) {
        this(Pin.class, forVariable(variable), INITS);
    }

    public QPin(Path<? extends Pin> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPin(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPin(PathMetadata metadata, PathInits inits) {
        this(Pin.class, metadata, inits);
    }

    public QPin(Class<? extends Pin> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.point = inits.isInitialized("point") ? new QPoint(forProperty("point"), inits.get("point")) : null;
        this.route = inits.isInitialized("route") ? new QRoute(forProperty("route"), inits.get("route")) : null;
    }

}

