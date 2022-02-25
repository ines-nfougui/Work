package tn.esprit.Work.IService;

import tn.esprit.Work.model.Question;

import java.util.List;

public interface IServiceQuestion {


    Question addQuestion(Question Question);

    String DeleteQuestion(Long QuestionId);

    Question updateQuestion(Question Question);

    List<Question> retrieveAllQuestion();

    Question findQuestionById(Long id);
}
