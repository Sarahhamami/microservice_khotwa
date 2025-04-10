package tn.esprit.khotwaback.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khotwaback.entities.Reponse;
import tn.esprit.khotwaback.repositories.CertificatCourRepository;
import tn.esprit.khotwaback.repositories.ReponseRepository;

import java.util.List;
@Service
@Slf4j
public class ReponseService implements IReponseService{
    @Autowired
    private ReponseRepository reponseRepository;
    @Override
    public Reponse addReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    @Override
    public Reponse updateReponse(Reponse reponse) {
        return reponseRepository.save(reponse);
    }

    @Override
    public List<Reponse> retrieveAllReponse() {
        return reponseRepository.findAll();
    }

    @Override
    public Reponse retrieveById(Long id_reponse) {
        return reponseRepository.findById(id_reponse).orElse(null);
    }

    @Override
    public void deleteReponseById(Long id_reponse) {
        reponseRepository.deleteById(id_reponse);
    }
}
