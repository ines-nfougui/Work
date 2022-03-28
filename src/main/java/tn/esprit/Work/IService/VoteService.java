package tn.esprit.Work.IService;


import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.User;
import tn.esprit.Work.model.Vote;



@Service
public interface VoteService {
	
	    List<Vote> retrieveAllVote();
	    Vote findVoteById(int r);
	    Vote findLikeByPublicationAndUser(Publication r, User user);
	    Vote addVoteLike(long idp , long idu, int note);
	  
	     
	

}
