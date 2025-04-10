package tn.esprit.khotwaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khotwaback.entities.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
