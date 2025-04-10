package tn.esprit.khotwaback.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khotwaback.entities.Commentaire_cours;
import tn.esprit.khotwaback.repositories.CertificatCourRepository;
import tn.esprit.khotwaback.repositories.CommentaireCourRepository;

import java.util.List;
@Service
@Slf4j
public class CommentaireCourService implements ICommentaireCourService{
    @Autowired
    private CommentaireCourRepository ComCRepository;
    @Override
    public Commentaire_cours addCommentaire_cours(Commentaire_cours commentaireCours) {
        return ComCRepository.save(commentaireCours);
    }

    @Override
    public Commentaire_cours updateCommentaire_cours(Commentaire_cours commentaireCours) {
        return ComCRepository.save(commentaireCours);
    }

    @Override
    public List<Commentaire_cours> retrieveAllCommentaire_cours() {
        return ComCRepository.findAll();
    }

    @Override
    public Commentaire_cours retrieveById(Long id_commentaire_cours) {
        return ComCRepository.findById(id_commentaire_cours).orElse(null);
    }

    @Override
    public void deleteCommentaire_coursById(Long id_commentaire_cours) {
        ComCRepository.deleteById(id_commentaire_cours);
    }
}
