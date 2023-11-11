package sk.tuke.pegasus.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QKlient is a Querydsl query type for Klient
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QKlient extends EntityPathBase<Klient> {

    private static final long serialVersionUID = 1397831173L;

    public static final QKlient klient = new QKlient("klient");

    public final StringPath adresa = createString("adresa");

    public final StringPath email = createString("email");

    public final NumberPath<Long> klientId = createNumber("klientId", Long.class);

    public final StringPath meno = createString("meno");

    public final StringPath priezvisko = createString("priezvisko");

    public final StringPath telefon = createString("telefon");

    public QKlient(String variable) {
        super(Klient.class, forVariable(variable));
    }

    public QKlient(Path<? extends Klient> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKlient(PathMetadata metadata) {
        super(Klient.class, metadata);
    }

}

