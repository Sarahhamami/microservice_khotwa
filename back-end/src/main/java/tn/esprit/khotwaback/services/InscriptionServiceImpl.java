package tn.esprit.khotwaback.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khotwaback.entities.Evenement;
import tn.esprit.khotwaback.entities.Inscription;
import tn.esprit.khotwaback.repositories.EvenementRepository;
import tn.esprit.khotwaback.repositories.InscriptionRepository;

@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    @Override
    public Inscription createInscription(Inscription inscription) {
        Evenement event = evenementRepository.findById(inscription.getEvenement().getEventId()).orElse(null);
        if (event != null && event.getCurrentParticipants() < event.getMaxParticipants()) {
            event.setCurrentParticipants(event.getCurrentParticipants() + 1);
            evenementRepository.save(event);
            return inscriptionRepository.save(inscription);
        }
        return null; // Ou lever une exception
    }

    @Override
    public int getNombreInscriptions(int eventId) {
        return inscriptionRepository.countByEvenementEventId(eventId);
    }
}