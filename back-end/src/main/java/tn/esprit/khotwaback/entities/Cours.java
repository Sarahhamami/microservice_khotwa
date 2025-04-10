package tn.esprit.khotwaback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cours;
    private String titre;
    private String description ;
    private int duree;
    private int prix;
    private String niveau;
    private String categorie;
    private Date date_publication;
    private int nb_etudiantsEnrolled;
    private float rating;
    private String format;
    private String fichier;
    private String image;
    private String video;
    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    @ToString.Exclude
    private List<Certificat_cours> certificatCours;
    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    @ToString.Exclude
    private List<Commentaire_cours> commentaireCours;
    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    @ToString.Exclude
    private List<Quizz> quizzes;

}
