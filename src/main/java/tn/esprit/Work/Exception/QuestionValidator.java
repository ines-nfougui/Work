package tn.esprit.Work.Exception;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tn.esprit.Work.model.Question;

@Component
    public class QuestionValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Question.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Question question = (Question) o ;
    }
}
