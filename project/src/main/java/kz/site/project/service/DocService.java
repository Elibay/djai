package kz.site.project.service;

import kz.site.project.Model.Doc;

import java.util.List;
import java.util.Optional;

public interface DocService {

    List<Doc> findAll();

    Optional<Doc> findById(String id);

    void saveOrUpdate(Doc document);

    void deleteElement(String id);
}
