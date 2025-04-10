package tn.esprit.khotwaback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;
    private String title;
    private String description;
    private Date date;
    private String location;

    @Enumerated(EnumType.STRING)
    private Type_evenement type;

    private int maxParticipants;
    private int currentParticipants;
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Status_evenement status;

    @OneToMany(mappedBy = "evenement")
    private List<Certificat_evenement> certificatEvenements;

    @OneToMany(mappedBy = "evenement")
    private List<Commentaire_evenement> commentaireEvenements;


}