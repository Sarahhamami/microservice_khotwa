package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Evenement;
import tn.esprit.khotwaback.services.EvenementService;
import java.util.List;

@RestController
@RequestMapping("/evenements")
@CrossOrigin(origins = "*")
public class EvenementController {

    @Autowired
    private EvenementService evenementService;

    @PostMapping("/create")
    public Evenement createEvenement(@RequestBody Evenement evenement) {
        return evenementService.createEvenement(evenement);
    }

    @PutMapping("/update/{id}")
    public Evenement updateEvenement(@PathVariable("id") int eventId, @RequestBody Evenement evenement) {
        return evenementService.updateEvenement(eventId, evenement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvenement(@PathVariable("id") int eventId) {
        evenementService.deleteEvenement(eventId);
    }

    @GetMapping("/all")
    public List<Evenement> getAllEvenements() {
        return evenementService.getAllEvenements();
    }

    @GetMapping("/{id}")
    public Evenement getEvenementById(@PathVariable int eventId) {
        return evenementService.getEvenementById(eventId);
    }


}