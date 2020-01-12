package kz.site.project.repository;

import kz.site.project.Model.Doc;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Repo extends MongoRepository<Doc, String> {

    List<Doc> findByValue(String value);

}
