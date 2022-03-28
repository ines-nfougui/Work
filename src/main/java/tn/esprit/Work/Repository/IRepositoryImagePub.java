package tn.esprit.Work.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Work.model.UploadImagePublication;
import tn.esprit.Work.model.UploadImagePublicite;

@Repository
public interface IRepositoryImagePub extends CrudRepository<UploadImagePublication,Long> {
}
