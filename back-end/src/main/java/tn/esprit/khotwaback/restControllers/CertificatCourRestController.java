package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Certificat_cours;
import tn.esprit.khotwaback.services.ICertificatService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CertificatCourRestController {
    @Autowired
    private ICertificatService icc;
    @PostMapping("/addCC")
    public Certificat_cours addCC(@RequestBody Certificat_cours certificat_cours) {
        return icc.addCertificat_cours(certificat_cours);
    }
    @PutMapping("/updateCC")
    public Certificat_cours updateCC(@RequestBody Certificat_cours certificat_cours)
    {return icc.updateCertificat_cours(certificat_cours);}
    @GetMapping("/retrieveAllCC")
    public List<Certificat_cours> retrieveAllCC(){return icc.retrieveAllCertificat_cours();}
    @GetMapping("/retrieveCC/{id_certificat_cours}")
    public Certificat_cours retrieveById(@PathVariable Long id_certificat_cours){return icc.retrieveById(id_certificat_cours);}
    @DeleteMapping("/deleteCC/{id_certificat_cours}")
    public void deleteCoursById(@PathVariable Long id_certificat_cours){ icc.deleteCertificat_coursById(id_certificat_cours);}
}
