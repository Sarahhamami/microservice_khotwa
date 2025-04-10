package tn.esprit.khotwaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khotwaback.entities.Commentaire_cours;

public interface CommentaireCourRepository extends JpaRepository<Commentaire_cours,Long> {
}
