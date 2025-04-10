package tn.esprit.khotwaback.services;


import tn.esprit.khotwaback.entities.Commentaire_cours;

import java.util.List;

public interface ICommentaireCourService {
    public Commentaire_cours addCommentaire_cours(Commentaire_cours commentaireCours);
    public Commentaire_cours updateCommentaire_cours(Commentaire_cours commentaireCours);
    public List<Commentaire_cours> retrieveAllCommentaire_cours();
    public Commentaire_cours retrieveById(Long id_commentaire_cours);
    public void deleteCommentaire_coursById(Long id_commentaire_cours);
}
