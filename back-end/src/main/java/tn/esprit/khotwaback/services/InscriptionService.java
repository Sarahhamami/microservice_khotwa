package tn.esprit.khotwaback.services;

import tn.esprit.khotwaback.entities.Inscription;

public interface InscriptionService {
    Inscription createInscription(Inscription inscription);
    int getNombreInscriptions(int eventId);
}