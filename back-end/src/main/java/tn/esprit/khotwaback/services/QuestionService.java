package tn.esprit.khotwaback.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khotwaback.entities.Question;
import tn.esprit.khotwaback.repositories.QuestionRepository;

import java.util.List;

@Service
@Slf4j
public class QuestionService implements IQuestionService{
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> retrieveAllQuestion() {
        return questionRepository.findAll();
    }

    @Override
    public Question retrieveById(Long id_question) {
        return questionRepository.findById(id_question).orElse(null);
    }

    @Override
    public void deleteQuestionById(Long id_question) {
        questionRepository.deleteById(id_question);
    }
}
