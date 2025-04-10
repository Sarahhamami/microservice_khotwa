package tn.esprit.khotwaback.services;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.khotwaback.entities.Cours;

import java.util.List;

public interface ICoursService {
    public Cours addCours(Cours cours , MultipartFile image, MultipartFile fichier, MultipartFile video);
    public Cours updateCours(Cours cours);
    public List<Cours> retrieveAllCours();
    public Cours retrieveById(Long id_cours);
    public void deleteCoursById(Long id_cours);
    List<Cours> searchCoursByTitre(String titre);
    public Cours getCourseByTitle(String title);


    List<Cours> searchCoursByCategory(String categorie);
}
