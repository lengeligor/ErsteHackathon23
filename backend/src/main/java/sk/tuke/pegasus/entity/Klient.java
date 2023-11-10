package sk.tuke.pegasus.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "klient")
public class Klient implements Serializable {

    @Id
    @GeneratedValue
    @Column(unique = true , nullable = false)
    private Long klientId;

    private String meno;
    private String priezvisko;
    private String adresa;
    private String email;
    private String telefon;

}
