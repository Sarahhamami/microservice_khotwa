package tn.esprit.khotwaback.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.khotwaback.entities.Quizz;
import tn.esprit.khotwaback.repositories.QuizzRepository;

import java.util.List;

@Service
@Slf4j
public class QuizzService implements IQuizzService{
    @Autowired
    private QuizzRepository quizzRepository;
    @Override
    public Quizz addQuizz(Quizz quizz) {
        return quizzRepository.save(quizz);
    }

    @Override
    public Quizz updateQuizz(Quizz quizz) {
        return quizzRepository.save(quizz);
    }

    @Override
    public List<Quizz> retrieveAllQuizz() {
        return quizzRepository.findAll();
    }

    @Override
    public Quizz retrieveById(Long idQuizz) {
        return quizzRepository.findById(idQuizz).orElse(null);
    }

    @Override
    public void deleteQuizzById(Long idQuizz) {
        quizzRepository.deleteById(idQuizz);
    }
}
