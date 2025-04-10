package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Certificat_cours;
import tn.esprit.khotwaback.entities.Reponse;
import tn.esprit.khotwaback.services.ICertificatService;
import tn.esprit.khotwaback.services.IReponseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ReponseRestController {
    @Autowired
    private IReponseService iReponseService;
    @PostMapping("/addReponse")
    public Reponse addReponse(@RequestBody Reponse reponse) {
        return iReponseService.addReponse(reponse);
    }
    @PutMapping("/updateReponse")
    public Reponse updateReponse(@RequestBody Reponse reponse)
    {return iReponseService.updateReponse(reponse);}
    @GetMapping("/retrieveAllReponses")
    public List<Reponse> retrieveAllReponses(){return iReponseService.retrieveAllReponse();}
    @GetMapping("/retrieveReponse/{id_reponse}")
    public Reponse retrieveById(@PathVariable Long id_reponse){return iReponseService.retrieveById(id_reponse);}
    @DeleteMapping("/deleteReponse/{id_reponse}")
    public void deleteReponseById(@PathVariable Long id_reponse){ iReponseService.deleteReponseById(id_reponse);}

}
