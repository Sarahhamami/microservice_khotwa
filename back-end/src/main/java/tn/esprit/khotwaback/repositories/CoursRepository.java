package tn.esprit.khotwaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khotwaback.entities.Cours;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours,Long> {
    List<Cours>findByTitreContainingIgnoreCase(String titre);
    List<Cours>findByCategorieContainingIgnoreCase(String category);
}
