package tn.esprit.khotwaback.services;

import tn.esprit.khotwaback.entities.Certificat_cours;

import java.util.List;

public interface ICertificatService {
    public Certificat_cours addCertificat_cours(Certificat_cours certificat_cours);
    public Certificat_cours updateCertificat_cours(Certificat_cours certificat_cours);
    public List<Certificat_cours> retrieveAllCertificat_cours();
    public Certificat_cours retrieveById(Long id_certificat_cours);
    public void deleteCertificat_coursById(Long id_certificat_cours);
}
