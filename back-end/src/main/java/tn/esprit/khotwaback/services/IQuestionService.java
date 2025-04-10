package tn.esprit.khotwaback.services;

import tn.esprit.khotwaback.entities.Question;

import java.util.List;

public interface IQuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public List<Question> retrieveAllQuestion();
    public Question retrieveById(Long id_question);
    public void deleteQuestionById(Long id_question);
}
