package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IUserSerive;
import tn.esprit.Work.Repository.IRepositoryUser;
import tn.esprit.Work.model.User;

@Service
public class ServiceUser implements IUserSerive {


    @Autowired
    IRepositoryUser repositoryUser ;

    public User findUserById(Long id){
        return this.repositoryUser.findById(id).orElse(null);

    }
}
