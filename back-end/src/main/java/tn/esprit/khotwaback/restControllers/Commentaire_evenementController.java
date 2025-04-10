package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Commentaire_evenement;
import tn.esprit.khotwaback.services.Commentaire_evenementService;

import java.util.List;

@RestController
@RequestMapping("/commentaires")
public class Commentaire_evenementController {

    @Autowired
    private Commentaire_evenementService commentaireEvenementService;

    @PostMapping("/add")
    public Commentaire_evenement addCommentaire(@RequestBody Commentaire_evenement commentaire) {
        return commentaireEvenementService.addCommentaire(commentaire);
    }

    @PutMapping("/update/{id}")
    public Commentaire_evenement updateCommentaire(@PathVariable int id, @RequestBody Commentaire_evenement commentaire) {
        return commentaireEvenementService.updateCommentaire(id, commentaire);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCommentaire(@PathVariable int id) {
        commentaireEvenementService.deleteCommentaire(id);
    }

    @GetMapping("/all")
    public List<Commentaire_evenement> getAllCommentaires() {
        return commentaireEvenementService.getAllCommentaires();
    }

    @GetMapping("/{id}")
    public Commentaire_evenement getCommentaireById(@PathVariable int id) {
        return commentaireEvenementService.getCommentaireById(id);
    }
}
