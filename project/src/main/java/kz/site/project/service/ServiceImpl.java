package kz.site.project.service;


import kz.site.project.Model.Doc;
import kz.site.project.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements DocService {

    @Autowired
    Repo repo;

    @Override
    public List<Doc> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Doc> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public void saveOrUpdate(Doc document) {
        repo.save(document);
    }

    @Override
    public void deleteElement(String id) {
        repo.deleteById(id);
    }
}
