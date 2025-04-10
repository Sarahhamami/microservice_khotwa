package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Inscription;
import tn.esprit.khotwaback.services.InscriptionService;

@RestController
@RequestMapping("/inscriptions")
@CrossOrigin(origins = "*")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping("/create")
    public ResponseEntity<?> createInscription(@RequestBody Inscription inscription) {
        Inscription savedInscription = inscriptionService.createInscription(inscription);
        if (savedInscription != null) {
            return ResponseEntity.ok(savedInscription);
        }
        return ResponseEntity.badRequest().body("L'événement a atteint sa capacité maximale");
    }

    @GetMapping("/count/{eventId}")
    public int getNombreInscriptions(@PathVariable int eventId) {
        return inscriptionService.getNombreInscriptions(eventId);
    }
}