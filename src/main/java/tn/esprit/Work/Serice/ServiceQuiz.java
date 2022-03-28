package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceQuiz;
import tn.esprit.Work.Repository.IRepositoryQuiz;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Quiz;

import java.util.List;

@Service
public class ServiceQuiz  implements IServiceQuiz {

    @Autowired
    IRepositoryQuiz repositoryQuiz ;

    @Override
    public Quiz addE(Quiz q) {
       return repositoryQuiz.save(q);
    }

    @Override
    public String DeleteQuiz(Long qId) {
        repositoryQuiz.delete(repositoryQuiz.findById(qId).get());
        return"Deleted";
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return repositoryQuiz.save(quiz);
    }

    @Override
    public List<Quiz> retrieveAllQuiz() {
        List<Quiz> quizs=(List<Quiz>)repositoryQuiz.findAll();
        return quizs;
    }

    @Override
    public Quiz findQuizById(Long id) {
        return this.repositoryQuiz.findById(id).orElse(null);

    }
}
