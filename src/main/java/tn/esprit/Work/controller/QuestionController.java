package tn.esprit.Work.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Work.Validator.QuestionValidator;
import tn.esprit.Work.IService.IServiceQuestion;
import tn.esprit.Work.Serice.MapValidationErrorService;
import tn.esprit.Work.model.Question;

import javax.validation.Valid;
import java.util.List;

@RestController
    @RequestMapping("/question")
public class QuestionController {

    @Autowired
    IServiceQuestion serviceQuestion ;

    @Autowired
    MapValidationErrorService mapValidationErrorService ;

    @Autowired
    QuestionValidator questionValidator ;

    @GetMapping("/retrieve-all-question")
    @ResponseBody
    public List<Question> getAllQuestions() {
        return serviceQuestion.retrieveAllQuestion();
    }

    @PostMapping("/add-question")
    @ResponseBody
    public ResponseEntity<?> addQuestion(@Valid  @RequestBody Question c , BindingResult result) {
            questionValidator.validate(c,result);
            ResponseEntity<?> erroMap =mapValidationErrorService.MapValidationService(result);
            if(erroMap != null)return erroMap;
            Question question = serviceQuestion.addQuestion(c);
            return new ResponseEntity<Question>( question, HttpStatus.CREATED);
    }

    @DeleteMapping("/remove-question/{question-id}")
    @ResponseBody
    public void removeQuestion(@PathVariable("question-id")  long questionid) {
        serviceQuestion.DeleteQuestion(questionid);

    }

    @PutMapping("/modify-Question")
    @ResponseBody
    public Question modifyQuestion(@RequestBody Question c) {
        return serviceQuestion.updateQuestion(c);
    }


    @GetMapping("/retrieve-Question/{questionId}")
    @ResponseBody
    public Question retrieveQuestion(@PathVariable("questionId") long questionId) {
        return serviceQuestion.findQuestionById(questionId);  }



}
