package sk.tuke.pegasus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QKarta is a Querydsl query type for Karta
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QKarta extends EntityPathBase<Karta> {

    private static final long serialVersionUID = -1479247929L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QKarta karta = new QKarta("karta");

    public final StringPath cisloKarty = createString("cisloKarty");

    public final DatePath<java.time.LocalDate> datumExpiracie = createDate("datumExpiracie", java.time.LocalDate.class);

    public final NumberPath<Long> kartaId = createNumber("kartaId", Long.class);

    public final StringPath stavKarty = createString("stavKarty");

    public final StringPath typKarty = createString("typKarty");

    public final QUcet ucetId;

    public QKarta(String variable) {
        this(Karta.class, forVariable(variable), INITS);
    }

    public QKarta(Path<? extends Karta> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QKarta(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QKarta(PathMetadata metadata, PathInits inits) {
        this(Karta.class, metadata, inits);
    }

    public QKarta(Class<? extends Karta> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ucetId = inits.isInitialized("ucetId") ? new QUcet(forProperty("ucetId"), inits.get("ucetId")) : null;
    }

}

