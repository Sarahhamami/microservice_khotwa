package tn.esprit.khotwaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.khotwaback.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    int countByEvenementEventId(int eventId); // Pour compter les inscriptions par événement
}