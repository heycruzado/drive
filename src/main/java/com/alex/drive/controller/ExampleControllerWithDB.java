package com.alex.drive.controller;

import com.alex.drive.model.Person;
import com.alex.drive.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ExampleControllerWithDB {

    private Person person;

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public ResponseEntity getAllPerson(){
        List<Person> list = personService.getAllPerson();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity getPersonById(@PathVariable("id") Long id){
        person = personService.getPersonById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body("Data: \n" +
                "Name: "+person.getName()+"\n"+
                "LastName: "+person.getLastName()+"\n"+
                "Phone: "+person.getPhone());
    }

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody Person person){
        person = personService.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                "Name: "+person.getName()+"\n" + "Last Name: "+person.getLastName()+"\n"+ "Phone: "+person.getPhone());
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> editPerson(@PathVariable("id") Long id, @RequestBody Person person){
        personService.editPerson(id, person);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(person);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity deletePerson(@PathVariable("id") Long id){
        personService.deletePersonById(id);
        return ResponseEntity.status(HttpStatus.OK).body("The person was deleted");
    }
}
