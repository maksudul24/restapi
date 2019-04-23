package io.codementor.gtommee.rest_tutorial;

import io.codementor.gtommee.rest_tutorial.models.Students;
import io.codementor.gtommee.rest_tutorial.repositories.StudentsRepositories;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController  {
  @Autowired
  private StudentsRepositories repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Students> getAllStudents() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Students getStudentById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyStudentById(@PathVariable("id") ObjectId id, @Valid @RequestBody Students pets) {
    pets.set_id(id);
    repository.save(pets);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Students createStudent(@Valid @RequestBody Students stud) {
    stud.set_id(ObjectId.get());
    repository.save(stud);
    return stud;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteStudent(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}