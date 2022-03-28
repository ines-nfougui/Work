package tn.esprit.Work.Serice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Work.IService.IServiceColloboration;
import tn.esprit.Work.IService.IServicePublicite;
import tn.esprit.Work.Repository.IRepositoryImagePub;
import tn.esprit.Work.Repository.IRepositoryImagePublicte;
import tn.esprit.Work.Repository.IRepositoryPublicite;
import tn.esprit.Work.model.Collaborateur;
import tn.esprit.Work.model.Commentaire;
import tn.esprit.Work.model.Publicite;
import tn.esprit.Work.model.UploadImagePublicite;

import java.util.List;

@Service
public class ServicePub implements IServicePublicite {

    @Autowired
    IRepositoryImagePublicte repositoryImagePublicte;
    @Autowired
    IRepositoryPublicite repositoryPublicite ;

    @Autowired
    IServiceColloboration serviceColloboration ;
    @Override
    public Publicite addPub(Publicite c) {
        return repositoryPublicite.save(c);
    }

    @Override
    public String DeletePub(Long corrId) {
        repositoryPublicite.delete(repositoryPublicite.findById(corrId).get());
        return"Deleted";
    }

    @Override
    public Publicite updatePub(Publicite c) {
        return repositoryPublicite.save(c);
    }

    @Override
    public List<Publicite> retrieveAllPub() {
        List<Publicite> pub=(List<Publicite>)repositoryPublicite.findAll();
        return pub;
    }

    @Override
    public List<Publicite> retrieveAllCollab(long IdCol) {
        Collaborateur c = serviceColloboration.findCollobrationById(IdCol);
        List<Publicite> pub=(List<Publicite>)repositoryPublicite.findPubliciteByIdColl(c);
        return pub;
    }

    @Override
    public UploadImagePublicite saveImage(UploadImagePublicite p) {
        return repositoryImagePublicte.save(p);
    }

    @Override
    public Publicite findPubById(Long id) {
        return repositoryPublicite.findById(id).get();
    }

    @Override
    public String statPubliciteParType(String type) {
        List<Publicite> lp = retrieveAllPub();
        float i =0;
        for (Publicite p :
                lp) {
            if (p.getTheme().name().toUpperCase().equals(type.toUpperCase()))

                i++;
        }
        float stat = (i/lp.size())*100;



        return"Pourcentage est : "+stat+"%";
    }
}
