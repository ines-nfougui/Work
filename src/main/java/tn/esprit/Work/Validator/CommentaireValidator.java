package tn.esprit.Work.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tn.esprit.Work.model.Commentaire;
import tn.esprit.Work.model.Publication;

@Component
public class CommentaireValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Commentaire.class.equals(aClass);
    }


    @Override
    public void validate(Object o, Errors errors) {

    }
}
