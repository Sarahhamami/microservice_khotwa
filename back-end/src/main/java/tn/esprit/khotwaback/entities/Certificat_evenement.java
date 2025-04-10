package tn.esprit.khotwaback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "certificat_evenement")
public class Certificat_evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomCertificat;
    private Date dateDelivrance;
    private String contenu;



    @ManyToOne
    private Evenement evenement;
}