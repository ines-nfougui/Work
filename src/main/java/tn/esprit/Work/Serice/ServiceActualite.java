package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceActualite;
import tn.esprit.Work.Repository.IRepositoryActualite;
import tn.esprit.Work.model.Actualite;

@Service
public class ServiceActualite implements IServiceActualite {

    @Autowired
    IRepositoryActualite repositoryActualite ;

    @Override
    public Actualite addActualite(Actualite c) {
        return repositoryActualite.save(c);
    }

    @Override
    public String DeleteActualite(Long corrId) {
        repositoryActualite.delete(repositoryActualite.findById(corrId).get());
        return"Deleted";
    }

    @Override
    public Actualite findActualiteById(Long id) {
        return this.repositoryActualite.findById(id).orElse(null);

    }
}
