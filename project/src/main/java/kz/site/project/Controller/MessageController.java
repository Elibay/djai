package kz.site.project.Controller;

import kz.site.project.Model.Doc;
import kz.site.project.service.DocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class MessageController {

    @Autowired
    DocService service;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Doc> result = service.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Optional<Doc> result = service.findById(id);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> addorUpdate(@RequestBody Doc doc) {
        service.saveOrUpdate(doc);
        return new ResponseEntity("Success", HttpStatus.OK);
    }

    @DeleteMapping
    public void delete(@RequestParam("id") String id) {
        service.deleteElement(id);
    }

}
