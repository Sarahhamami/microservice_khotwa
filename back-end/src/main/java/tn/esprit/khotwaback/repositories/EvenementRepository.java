package tn.esprit.khotwaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khotwaback.entities.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Integer> {
}
