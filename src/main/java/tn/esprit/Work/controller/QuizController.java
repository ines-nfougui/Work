package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.IService.IServiceQuestion;
import tn.esprit.Work.IService.IServiceQuiz;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.Validator.QuizValidator;
import tn.esprit.Work.model.Quiz;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {


    @Autowired
    IServiceQuiz serviceQuiz ;
    @Autowired
    IServiceQuestion serviceQuestion ;

    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    QuizValidator quizValidator ;

    @GetMapping("/retrieve-all-quiz")
    @ResponseBody
    public List<Quiz> getAllQuiz() {
        return serviceQuiz.retrieveAllQuiz();
    }

    @PostMapping("/add-quiz/{idQues}")
    @ResponseBody
    public ResponseEntity<?> addQuiz(@Valid @RequestBody Quiz c , @PathVariable("idQues")  long idQues ,BindingResult result) {
        quizValidator.validate(c,result);
        ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
        if(erroMap != null)return erroMap;
        c.setQuizQuestion(serviceQuestion.findQuestionById(idQues));
        Quiz q = serviceQuiz.addE(c);
        return new ResponseEntity<Quiz>( q, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove-quiz/{quiz-id}")
    @ResponseBody
    public void removeQuiz(@PathVariable("quiz-id")  long qId) {
        serviceQuiz.DeleteQuiz(qId);

    }

    @PutMapping("/modify-Quiz")
    @ResponseBody
    public Quiz modifyQuiz(@RequestBody Quiz c) {
        return serviceQuiz.updateQuiz(c);
    }


    @GetMapping("/retrieve-Quiz/{qId}")
    @ResponseBody
    public Quiz retrieveQuiz(@PathVariable("qId") long qId) {
        return serviceQuiz.findQuizById(qId);  }


}
