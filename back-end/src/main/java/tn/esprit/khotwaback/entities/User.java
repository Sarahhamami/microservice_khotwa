package tn.esprit.khotwaback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@ToString
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_user ;
    private String nom;
    private String prenom;
    private String email ;
    private String mdp ;
    private ROLE role;


    @OneToMany(mappedBy = "user")
    private  List<Commentaire_cours> commentaireCours ;
    @OneToMany(mappedBy = "user")
    private  List<Certificat_cours> certificatCours ;

}
