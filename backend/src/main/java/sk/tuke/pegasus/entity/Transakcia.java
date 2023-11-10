package sk.tuke.pegasus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transakcia")
public class Transakcia implements Serializable{

    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long transakciaId;

    @ManyToOne
    @JoinColumn(name = "kartaId", nullable = false)
    private Karta kartaId;

    private LocalDateTime datumCas;
    private BigDecimal suma;
    private String typTransakcie;
    private String popis;
    private  double stavPred ;
    private  double stavPo ;
    private char financnyTok;

    @ManyToOne
    @JoinColumn(name = "terminalId")
    private PlatobnyTerminal terminalId;
}
