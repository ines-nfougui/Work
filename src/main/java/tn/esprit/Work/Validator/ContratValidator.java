package tn.esprit.Work.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tn.esprit.Work.model.Contrat;


@Component
public class ContratValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Contrat.class.equals(aClass);

    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
