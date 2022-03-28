package tn.esprit.Work.IService;

import tn.esprit.Work.model.Commentaire;
import tn.esprit.Work.model.Publicite;
import tn.esprit.Work.model.UploadImagePublication;
import tn.esprit.Work.model.UploadImagePublicite;

import java.util.List;

public interface IServicePublicite {

    Publicite addPub(Publicite c);

    String DeletePub(Long corrId);

    Publicite updatePub(Publicite c);

    List<Publicite> retrieveAllPub();

    List<Publicite> retrieveAllCollab(long IdCol);

    UploadImagePublicite saveImage(UploadImagePublicite p);

    Publicite findPubById(Long id);

    String statPubliciteParType(String type);




}
