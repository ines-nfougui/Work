package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceColloboration;
import tn.esprit.Work.Repository.IRepositoryCollobrateur;
import tn.esprit.Work.model.Collaborateur;
import tn.esprit.Work.model.Evenements;

import java.util.List;

@Service
public class ServiceCollobrateur  implements IServiceColloboration {

    @Autowired
    IRepositoryCollobrateur repositoryCollobrateur ;



    @Override
    public Collaborateur addCollobration(Collaborateur c) {
        return repositoryCollobrateur.save(c);
    }

    @Override
    public String DeleteCollobration(Long corrId) {
        repositoryCollobrateur.delete(repositoryCollobrateur.findById(corrId).get());
        return"Deleted";
    }

    @Override
    public Collaborateur updateCollobration(Collaborateur c) {
        repositoryCollobrateur.save(c);
        return c ;
    }

    @Override
    public List<Collaborateur> retrieveAllCollobration() {
        List<Collaborateur> collob=(List<Collaborateur>)repositoryCollobrateur.findAll();
        return collob;
    }

    @Override
    public Collaborateur findCollobrationById(Long id) {
        return this.repositoryCollobrateur.findById(id).orElse(null);
    }
}
