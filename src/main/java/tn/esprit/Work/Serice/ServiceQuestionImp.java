package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceQuestion;
import tn.esprit.Work.Repository.IRepositoryQuestion;
import tn.esprit.Work.model.Question;

import java.util.List;

@Service
public class ServiceQuestionImp implements IServiceQuestion {


    @Autowired
    IRepositoryQuestion repositoryQuestion ;


    @Override
    public Question addQuestion(Question Question) {
           repositoryQuestion.save(Question);
           return Question;
    }

    @Override
    public String DeleteQuestion(Long QuestionId) {
        repositoryQuestion.delete(repositoryQuestion.findById(QuestionId).get());
        return"Deleted";
    }

    @Override
    public Question updateQuestion(Question Question) {
        repositoryQuestion.save(Question);
        return Question ;
    }

    @Override
    public List<Question> retrieveAllQuestion() {
        List<Question> questions=(List<Question>)repositoryQuestion.findAll();
        return questions;
    }

    @Override
    public Question findQuestionById(Long id) {
        return this.repositoryQuestion.findById(id).orElse(null);
    }
}
