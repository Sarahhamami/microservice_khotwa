package tn.esprit.khotwaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khotwaback.entities.Cours;
import tn.esprit.khotwaback.entities.Quizz;

public interface QuizzRepository extends JpaRepository<Quizz,Long> {
}
