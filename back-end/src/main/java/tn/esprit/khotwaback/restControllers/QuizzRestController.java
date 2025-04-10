package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Quizz;
import tn.esprit.khotwaback.entities.Quizz;
import tn.esprit.khotwaback.services.IQuizzService;
import tn.esprit.khotwaback.services.IQuizzService;

import java.util.List;

@RestController
public class QuizzRestController {
    @Autowired
    private IQuizzService iQuizzService;
    @PostMapping("/addQuizz")
    public Quizz addQuizz(@RequestBody Quizz quizz){return iQuizzService.addQuizz(quizz);}
    @PutMapping("/updateQuizz")
    public Quizz updateQuizz(@RequestBody Quizz quizz){return iQuizzService.updateQuizz(quizz);}
    @GetMapping("/retrieveAllQuizz")
    public List<Quizz> retrieveAllQuizz(){return iQuizzService.retrieveAllQuizz();}
    @GetMapping("/retrieveQuizz/{idQuizz}")
    public Quizz retrieveById(@PathVariable Long idQuizz){return iQuizzService.retrieveById(idQuizz);}
    @DeleteMapping("/deleteQuizz/{idQuizz}")
    public void deleteQuizzById(@PathVariable Long idQuizz){ iQuizzService.deleteQuizzById(idQuizz);}
}
