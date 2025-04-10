package tn.esprit.khotwaback.restControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.khotwaback.entities.Certificat_cours;
import tn.esprit.khotwaback.entities.Question;
import tn.esprit.khotwaback.services.ICertificatService;
import tn.esprit.khotwaback.services.IQuestionService;

import java.util.List;
@RestController
@CrossOrigin(origins = "*")
public class QuestionRestController {
    @Autowired
    private IQuestionService iQuestionService;
    @PostMapping("/addQuestion")
    public Question addQuestion(@RequestBody Question question) {
        return iQuestionService.addQuestion(question);
    }
    @PutMapping("/updateQuestion")
    public Question updateQuestion(@RequestBody Question question)
    {return iQuestionService.updateQuestion(question);}
    @GetMapping("/retrieveAllQuestions")
    public List<Question> retrieveAllQuestions(){return iQuestionService.retrieveAllQuestion();}
    @GetMapping("/retrieveQuestion/{id_question}")
    public Question retrieveById(@PathVariable Long id_question){return iQuestionService.retrieveById(id_question);}
    @DeleteMapping("/deleteQuestion/{id_question}")
    public void deleteQuestionById(@PathVariable Long id_question){ iQuestionService.deleteQuestionById(id_question);}

}
