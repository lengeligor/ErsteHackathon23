package sk.tuke.pegasus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTransakcia is a Querydsl query type for Transakcia
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTransakcia extends EntityPathBase<Transakcia> {

    private static final long serialVersionUID = -252080405L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTransakcia transakcia = new QTransakcia("transakcia");

    public final DateTimePath<java.time.LocalDateTime> datumCas = createDateTime("datumCas", java.time.LocalDateTime.class);

    public final ComparablePath<Character> financnyTok = createComparable("financnyTok", Character.class);

    public final QKarta kartaId;

    public final StringPath popis = createString("popis");

    public final NumberPath<Double> stavPo = createNumber("stavPo", Double.class);

    public final NumberPath<Double> stavPred = createNumber("stavPred", Double.class);

    public final NumberPath<java.math.BigDecimal> suma = createNumber("suma", java.math.BigDecimal.class);

    public final QPlatobnyTerminal terminalId;

    public final NumberPath<Long> transakciaId = createNumber("transakciaId", Long.class);

    public final StringPath typTransakcie = createString("typTransakcie");

    public QTransakcia(String variable) {
        this(Transakcia.class, forVariable(variable), INITS);
    }

    public QTransakcia(Path<? extends Transakcia> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTransakcia(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTransakcia(PathMetadata metadata, PathInits inits) {
        this(Transakcia.class, metadata, inits);
    }

    public QTransakcia(Class<? extends Transakcia> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.kartaId = inits.isInitialized("kartaId") ? new QKarta(forProperty("kartaId"), inits.get("kartaId")) : null;
        this.terminalId = inits.isInitialized("terminalId") ? new QPlatobnyTerminal(forProperty("terminalId")) : null;
    }

}

