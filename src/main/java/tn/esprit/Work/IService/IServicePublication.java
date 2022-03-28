package tn.esprit.Work.IService;

import tn.esprit.Work.model.Publication;
import tn.esprit.Work.model.UploadImagePublication;

import java.util.List;

public interface IServicePublication {



    Publication addPublication(Publication q);

    String DeletePublication(Long oId);

    UploadImagePublication saveImage(UploadImagePublication p);

    Publication updatePublication(Publication Publication);

    List<Publication> retrieveAllPublication();

    Publication findPublicationById(Long id);
}
