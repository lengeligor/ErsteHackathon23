package sk.tuke.pegasus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUcet is a Querydsl query type for Ucet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUcet extends EntityPathBase<Ucet> {

    private static final long serialVersionUID = 229676415L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUcet ucet = new QUcet("ucet");

    public final NumberPath<java.math.BigDecimal> aktualnyZostatok = createNumber("aktualnyZostatok", java.math.BigDecimal.class);

    public final DatePath<java.time.LocalDate> datumOtvorenia = createDate("datumOtvorenia", java.time.LocalDate.class);

    public final QKlient klientId;

    public final StringPath typUctu = createString("typUctu");

    public final NumberPath<Long> ucetId = createNumber("ucetId", Long.class);

    public QUcet(String variable) {
        this(Ucet.class, forVariable(variable), INITS);
    }

    public QUcet(Path<? extends Ucet> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUcet(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUcet(PathMetadata metadata, PathInits inits) {
        this(Ucet.class, metadata, inits);
    }

    public QUcet(Class<? extends Ucet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.klientId = inits.isInitialized("klientId") ? new QKlient(forProperty("klientId")) : null;
    }

}

