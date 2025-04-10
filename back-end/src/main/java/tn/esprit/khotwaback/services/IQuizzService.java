package tn.esprit.khotwaback.services;

import tn.esprit.khotwaback.entities.Quizz;

import java.util.List;

public interface IQuizzService {
    public Quizz addQuizz(Quizz quizz);
    public Quizz updateQuizz(Quizz quizz);
    public List<Quizz> retrieveAllQuizz();
    public Quizz retrieveById(Long idQuizz);
    public void deleteQuizzById(Long idQuizz);
}
