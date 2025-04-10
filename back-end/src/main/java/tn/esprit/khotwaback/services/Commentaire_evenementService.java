package tn.esprit.khotwaback.services;

import tn.esprit.khotwaback.entities.Commentaire_evenement;

import java.util.List;

public interface Commentaire_evenementService {
    Commentaire_evenement addCommentaire(Commentaire_evenement commentaire);
    Commentaire_evenement updateCommentaire(int id, Commentaire_evenement commentaire);
    void deleteCommentaire(int id);
    List<Commentaire_evenement> getAllCommentaires();
    Commentaire_evenement getCommentaireById(int id);
}