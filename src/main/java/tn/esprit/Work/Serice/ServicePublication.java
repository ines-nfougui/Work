package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServicePublication;
import tn.esprit.Work.Repository.IRepositoryImagePub;
import tn.esprit.Work.Repository.IRepositoryPublication;
import tn.esprit.Work.model.Commentaire;
import tn.esprit.Work.model.Offer;
import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.UploadImagePublication;

import java.util.List;

@Service
public class ServicePublication implements IServicePublication {

    @Autowired
    IRepositoryPublication repositoryPublication ;
    @Autowired
    IRepositoryImagePub repositoryImagePub ;


    @Override
    public Publication addPublication(Publication q) {
        return repositoryPublication.save(q);
    }

    @Override
    public String DeletePublication(Long oId) {
        repositoryPublication.delete(repositoryPublication.findById(oId).get());
        return"Deleted";
    }

    @Override
    public Publication updatePublication(Publication Publication) {
        return repositoryPublication.save(Publication);
    }

    @Override
    public List<Publication> retrieveAllPublication() {

        List<Publication> pubs=(List<Publication>)repositoryPublication.findAll();
        return pubs;
    }

    @Override
    public Publication findPublicationById(Long id) {
        return this.repositoryPublication.findById(id).orElse(null);

    }

    public UploadImagePublication saveImage(UploadImagePublication p){
        return repositoryImagePub.save(p);

    }


}
