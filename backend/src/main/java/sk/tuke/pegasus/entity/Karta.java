package sk.tuke.pegasus.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "karta")
public class Karta implements Serializable {
    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long kartaId;

    @ManyToOne
    @JoinColumn(name = "ucetId", nullable = false)
    private Ucet ucetId;

    private String cisloKarty;
    private LocalDate datumExpiracie;
    private String typKarty;
    private String stavKarty;
}
