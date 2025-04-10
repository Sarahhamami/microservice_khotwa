package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.khotwaback.entities.Cours;
import tn.esprit.khotwaback.services.ICoursService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CoursRestController {
    @Autowired
    private ICoursService iCoursService;
    @PostMapping(value = "/addCours", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Cours addCours(
            @RequestPart("cours") Cours cours,
            @RequestPart("image") MultipartFile image,
            @RequestPart(value = "fichier", required = false) MultipartFile fichier,
            @RequestPart(value = "video", required = false) MultipartFile video)
     {
        return iCoursService.addCours(cours, image, fichier, video);
    }
    @PutMapping("/updateCours")
    public Cours updateCours(@RequestBody Cours cours){return iCoursService.updateCours(cours);}
    @GetMapping("/retrieveAllCours")
    public List<Cours> retrieveAllCours(){return iCoursService.retrieveAllCours();}
    @GetMapping("/retrieveCours/{id_cours}")
    public Cours retrieveById(@PathVariable Long id_cours){return iCoursService.retrieveById(id_cours);}
    @DeleteMapping("/deleteCours/{id_cours}")
    public void deleteCoursById(@PathVariable Long id_cours){ iCoursService.deleteCoursById(id_cours);}
    @GetMapping("/search")
    public List<Cours> searchCours(@RequestParam String titre) {
        return iCoursService.searchCoursByTitre(titre);
    }
    @GetMapping("/searchByCategory")
    public List<Cours> searchCoursByCategory(@RequestParam String categorie) {
        return iCoursService.searchCoursByCategory(categorie);
    }




}
