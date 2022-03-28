package tn.esprit.Work.Serice;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.Work.IService.IUserSerive;
import tn.esprit.Work.IService.VoteService;
import tn.esprit.Work.Repository.VoteRepository;
import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.User;
import tn.esprit.Work.model.Vote;



@Service
public class VoteServiceImp implements VoteService {

    @Autowired
    VoteRepository VoteRepo ;
    @Autowired
    IUserSerive usersService;
    @Autowired
    ServicePublication publicationservice;

    @Override
    public List<Vote> retrieveAllVote() {
        List<Vote> votes = (List<Vote>) VoteRepo.findAll();
        return votes;
    }

    @Override
    public Vote findVoteById(int r) {
        return this.VoteRepo.findById(r).get();
    }


    @Override
    @Transactional
    public Vote addVoteLike( long idp , long idu, int note) {
    	Publication p = publicationservice.findPublicationById(idp);
        Vote vote = findLikeByPublicationAndUser(p,usersService.findUserById(idu));
        System.out.println(vote);
        if(vote==null)
        	vote = new Vote();
        
        vote.setUser(usersService.findUserById(idu));
        vote.setPublication(publicationservice.findPublicationById(idp));
        vote.setNote(note);
        vote =VoteRepo.save(vote);
        Map<String,Long> productNote = VoteRepo.getPubicationtNote(p);
        Long val1 =  productNote.get("val1");
        Long val2 =  productNote.get("val2");
        p.setNote((Double.valueOf(val1+"")/Double.valueOf(val2+"")));
        publicationservice.updatePublication(p);
        return vote;

    }

 



   

	@Override
	public Vote findLikeByPublicationAndUser(Publication r, User user) {
		return  VoteRepo.SearchLike(r,user);
	}


}


