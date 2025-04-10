package tn.esprit.khotwaback.services;

import tn.esprit.khotwaback.entities.Evenement;
import java.util.List;

public interface EvenementService {
    Evenement createEvenement(Evenement evenement);
    Evenement updateEvenement(int eventId, Evenement evenement);
    void deleteEvenement(int eventId);
    List<Evenement> getAllEvenements();
    Evenement getEvenementById(int eventId);

}