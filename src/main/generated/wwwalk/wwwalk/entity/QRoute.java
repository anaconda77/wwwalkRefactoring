package wwwalk.wwwalk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRoute is a Querydsl query type for Route
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRoute extends EntityPathBase<Route> {

    private static final long serialVersionUID = 993966270L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRoute route = new QRoute("route");

    public final DateTimePath<java.time.LocalDateTime> duration = createDateTime("duration", java.time.LocalDateTime.class);

    public final NumberPath<Double> endPointX = createNumber("endPointX", Double.class);

    public final NumberPath<Double> endPointY = createNumber("endPointY", Double.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> length = createNumber("length", Integer.class);

    public final QMember member;

    public final StringPath musicUrl = createString("musicUrl");

    public final StringPath name = createString("name");

    public final DateTimePath<java.time.LocalDateTime> rDate = createDateTime("rDate", java.time.LocalDateTime.class);

    public final EnumPath<State> security = createEnum("security", State.class);

    public final NumberPath<Double> startPointX = createNumber("startPointX", Double.class);

    public final NumberPath<Double> startPointY = createNumber("startPointY", Double.class);

    public final ListPath<String, StringPath> tags = this.<String, StringPath>createList("tags", String.class, StringPath.class, PathInits.DIRECT2);

    public QRoute(String variable) {
        this(Route.class, forVariable(variable), INITS);
    }

    public QRoute(Path<? extends Route> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRoute(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRoute(PathMetadata metadata, PathInits inits) {
        this(Route.class, metadata, inits);
    }

    public QRoute(Class<? extends Route> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

