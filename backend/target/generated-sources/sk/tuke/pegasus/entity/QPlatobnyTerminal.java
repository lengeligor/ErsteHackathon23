package sk.tuke.pegasus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QPlatobnyTerminal is a Querydsl query type for PlatobnyTerminal
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlatobnyTerminal extends EntityPathBase<PlatobnyTerminal> {

    private static final long serialVersionUID = -204752149L;

    public static final QPlatobnyTerminal platobnyTerminal = new QPlatobnyTerminal("platobnyTerminal");

    public final StringPath miestoTransakcie = createString("miestoTransakcie");

    public final NumberPath<Long> terminalId = createNumber("terminalId", Long.class);

    public final StringPath typTerminalu = createString("typTerminalu");

    public QPlatobnyTerminal(String variable) {
        super(PlatobnyTerminal.class, forVariable(variable));
    }

    public QPlatobnyTerminal(Path<? extends PlatobnyTerminal> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPlatobnyTerminal(PathMetadata metadata) {
        super(PlatobnyTerminal.class, metadata);
    }

}

