package tn.esprit.Work.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tn.esprit.Work.model.Quiz;

@Component
public class QuizValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Quiz.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Quiz q = (Quiz) o ;
    }
}
