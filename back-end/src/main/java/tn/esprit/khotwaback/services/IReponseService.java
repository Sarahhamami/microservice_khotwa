package tn.esprit.khotwaback.services;

import tn.esprit.khotwaback.entities.Reponse;

import java.util.List;

public interface IReponseService {
    public Reponse addReponse(Reponse reponse);
    public Reponse updateReponse(Reponse reponse);
    public List<Reponse> retrieveAllReponse();
    public Reponse retrieveById(Long id_reponse);
    public void deleteReponseById(Long id_reponse);
}
