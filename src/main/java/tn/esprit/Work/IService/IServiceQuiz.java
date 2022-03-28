package tn.esprit.Work.IService;

import tn.esprit.Work.model.Quiz;

import java.util.List;

public interface IServiceQuiz {

    Quiz addE(Quiz q);

    String DeleteQuiz(Long qId);

    Quiz updateQuiz(Quiz quiz);

    List<Quiz> retrieveAllQuiz();

    Quiz findQuizById(Long id);
}
