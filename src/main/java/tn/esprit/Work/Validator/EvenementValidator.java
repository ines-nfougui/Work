package tn.esprit.Work.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Offer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class EvenementValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Evenements.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Evenements q = (Evenements) o ;
        Date datede = q.getDateStart();
        Date datearr = q.getDateEnd();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDatede = dateFormat.format(datede);
        String strDatearr = dateFormat.format(datearr);

        if(datearr.before(datede)){
            errors.rejectValue("dateStart","date","vérifier votre date");

        }


    }
}
