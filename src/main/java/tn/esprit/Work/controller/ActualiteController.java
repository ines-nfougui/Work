package tn.esprit.Work.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Work.IService.IServiceActualite;
import tn.esprit.Work.IService.IServiceEvenements;
import tn.esprit.Work.IService.IServiceOffer;
import tn.esprit.Work.IService.IServicePublication;
import tn.esprit.Work.IService.IServiceQuiz;
import tn.esprit.Work.model.Actualite;
import tn.esprit.Work.model.Evenements;
import tn.esprit.Work.model.Offer;
import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.Quiz;

@RestController
public class ActualiteController {
	
	@Autowired
	IServiceOffer serviceOffer ;
	
	@Autowired
	IServiceEvenements serviceEvenements ;
	
	@Autowired
	IServicePublication servicePublication ;
	
	@Autowired
	IServiceQuiz serviceQuiz;
	
	@Autowired
	IServiceActualite serviceActualite;
	
    @PostMapping("/add-actualite")
    @ResponseBody
    public void addEvent() {
	       System.out.print("s");

    	java.util.List<Offer> lo = serviceOffer.retrieveAllOffer();
    	java.util.List<Evenements> le = serviceEvenements.retrieveAllEvenement();
    	java.util.List<Quiz> lq = serviceQuiz.retrieveAllQuiz();
    	java.util.List<Publication> lp = servicePublication.retrieveAllPublication();
    	LocalDate dd = LocalDate.now();
        Date date = java.sql.Date.valueOf(dd);
	       System.out.print("f");

        
    	
    	for (Publication publication : lp) {
    		
    		   try {

    		       long diff = date.getTime() - publication.getDateC().getTime();
    		       TimeUnit time = TimeUnit.DAYS; 
    		       long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
    		       System.out.print("pub"+diffrence);
    		       
    		       if (diffrence <2) {
    		    	   Actualite a = new Actualite();
    		    	   a.setIdpublicqtion(publication);
    		    	   serviceActualite.addActualite(a);
    		       }
    		        
    		   } catch (Exception e) {
    		       e.printStackTrace();
    		   }
    		
			
		}
    	
    	
    	
    	for (Offer offer : lo) {
    		
    		   try {

    		       long diff = date.getTime() - offer.getDateC().getTime();
    		       TimeUnit time = TimeUnit.DAYS; 
    		       long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
    		       System.out.print("pub"+diffrence);
    		       
    		       if (diffrence <2) {
    		    	   Actualite a = new Actualite();
    		    	   a.setIdoffer(offer);
    		    	   serviceActualite.addActualite(a);
    		       }
    		        
    		   } catch (Exception e) {
    		       e.printStackTrace();
    		   }
    		
			
		}
    	
    	
    	
    	for (Evenements evenements : le) {
    		
    		   try {

    		       long diff = date.getTime() - evenements.getDateC().getTime();
    		       TimeUnit time = TimeUnit.DAYS; 
    		       long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
    		       System.out.print("pub"+diffrence);
    		       if (diffrence <2) {
    		    	   Actualite a = new Actualite();
    		    	   a.setIdevent(evenements);
    		    	   serviceActualite.addActualite(a);
    		       }
    		        
    		   } catch (Exception e) {
    		       e.printStackTrace();
    		   }
    		
			
		}
    	
    	
    	
    	for (Quiz quiz : lq) {
    		
    		   try {

    		       long diff = date.getTime() - quiz.getDateC().getTime();
    		       TimeUnit time = TimeUnit.DAYS; 
    		       long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
    		       System.out.print("pub"+diffrence);
    		       
    		       if (diffrence <2) {
    		    	   Actualite a = new Actualite();
    		    	   a.setIdquiz(quiz);
    		    	   serviceActualite.addActualite(a);
    		       }
    		        
    		   } catch (Exception e) {
    		       e.printStackTrace();
    		   }
    		
			
		}

        
        
        
        
        //a.setIdevent();
    }

}
