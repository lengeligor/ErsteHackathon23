package sk.tuke.pegasus.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "ucet")
public class Ucet implements Serializable {

    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long ucetId;

    @ManyToOne
    @JoinColumn(name = "klientId", nullable = false)
    private Klient klientId;

    private String typUctu;
    private BigDecimal aktualnyZostatok;
    private LocalDate datumOtvorenia;

}
