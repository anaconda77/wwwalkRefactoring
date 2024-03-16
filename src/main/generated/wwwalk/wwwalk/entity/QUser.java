package wwwalk.wwwalk.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1907506506L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Integer> distance = createNumber("distance", Integer.class);

    public final StringPath id = createString("id");

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final EnumPath<State> state = createEnum("state", State.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

