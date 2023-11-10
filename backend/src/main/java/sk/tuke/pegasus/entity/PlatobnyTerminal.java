package sk.tuke.pegasus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "platobny_terminal")
public class PlatobnyTerminal implements Serializable {

    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long terminalId;

    private String miestoTransakcie;
    private String typTerminalu;

}
