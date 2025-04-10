package tn.esprit.khotwaback.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khotwaback.entities.Certificat_cours;
import tn.esprit.khotwaback.repositories.CertificatCourRepository;


import java.util.List;

@Service
@Slf4j
public class CertificatService implements ICertificatService{
    @Autowired
    private CertificatCourRepository CCRepository;
    @Override
    public Certificat_cours addCertificat_cours(Certificat_cours certificat_cours) {
        return CCRepository.save(certificat_cours);
    }

    @Override
    public Certificat_cours updateCertificat_cours(Certificat_cours certificat_cours) {
        return CCRepository.save(certificat_cours);
    }

    @Override
    public List<Certificat_cours> retrieveAllCertificat_cours() {
        return CCRepository.findAll();
    }

    @Override
    public Certificat_cours retrieveById(Long id_certificat_cours) {
        return CCRepository.findById(id_certificat_cours).orElse(null);
    }

    @Override
    public void deleteCertificat_coursById(Long id_certificat_cours) {
        CCRepository.deleteById(id_certificat_cours);

    }
}
