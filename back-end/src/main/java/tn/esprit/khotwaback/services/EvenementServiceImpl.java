package tn.esprit.khotwaback.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khotwaback.entities.Evenement;
import tn.esprit.khotwaback.repositories.EvenementRepository;

import java.util.List;

@Service
@Transactional
public class EvenementServiceImpl implements EvenementService {

    @Autowired
    private EvenementRepository evenementRepository;
    @Override
    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    @Override
    public Evenement updateEvenement(int eventId, Evenement evenement) {
        return evenementRepository.findById(eventId)
                .map(existingEvent -> {
                    existingEvent.setTitle(evenement.getTitle());
                    existingEvent.setDescription(evenement.getDescription());
                    existingEvent.setDate(evenement.getDate());
                    existingEvent.setLocation(evenement.getLocation());
                    existingEvent.setType(evenement.getType());
                    existingEvent.setMaxParticipants(evenement.getMaxParticipants());
                    existingEvent.setCurrentParticipants(evenement.getCurrentParticipants());
                    existingEvent.setImageUrl(evenement.getImageUrl());
                    existingEvent.setStatus(evenement.getStatus());
                    return evenementRepository.save(existingEvent);
                })
                .orElse(null);
    }

    @Override
    public void deleteEvenement(int eventId) {
        evenementRepository.findById(eventId).ifPresent(evenementRepository::delete);
    }

    @Override
    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    @Override
    public Evenement getEvenementById(int eventId) {
        return evenementRepository.findById(eventId).orElse(null);
    }


}