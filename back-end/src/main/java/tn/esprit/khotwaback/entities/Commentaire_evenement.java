package tn.esprit.khotwaback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "commentaire_evenement")
public class Commentaire_evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String texte;
    private Date datePublication;
    private int note;


    @ManyToOne

    private Evenement evenement;


    public void setId_commentaire_evenement(int eventId) {
    }
}