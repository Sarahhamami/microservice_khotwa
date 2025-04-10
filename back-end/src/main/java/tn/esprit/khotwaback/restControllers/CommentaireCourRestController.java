package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Certificat_cours;
import tn.esprit.khotwaback.entities.Commentaire_cours;
import tn.esprit.khotwaback.services.ICertificatService;
import tn.esprit.khotwaback.services.ICommentaireCourService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CommentaireCourRestController {

    @Autowired
    private ICommentaireCourService icomc;
    @PostMapping("/addComC")
    public Commentaire_cours addComC(@RequestBody Commentaire_cours commentaireCours) {
        return icomc.addCommentaire_cours(commentaireCours);
    }
    @PutMapping("/updateComC")
    public Commentaire_cours updateComC(@RequestBody Commentaire_cours commentaireCours)
    {return icomc.updateCommentaire_cours(commentaireCours);}
    @GetMapping("/retrieveAllComC")
    public List<Commentaire_cours> retrieveAllComC(){return icomc.retrieveAllCommentaire_cours();}
    @GetMapping("/retrieveComC/{id_commentaire_cours}")
    public Commentaire_cours retrieveById(@PathVariable Long id_commentaire_cours){return icomc.retrieveById(id_commentaire_cours);}
    @DeleteMapping("/deleteComC/{id_commentaire_cours}")
    public void deleteComCById(@PathVariable Long id_commentaire_cours){ icomc.deleteCommentaire_coursById(id_commentaire_cours);}

}
