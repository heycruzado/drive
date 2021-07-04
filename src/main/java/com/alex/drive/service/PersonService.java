package com.alex.drive.service;

import com.alex.drive.model.Person;
import com.alex.drive.repository.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private Person person;

    @Autowired
    private ExampleRepository repository;

    public List<Person> getAllPerson(){
        return repository.findAll();
    }

    public Person getPersonById(Long id){
        return repository.getById(id);
    }

    public Person createPerson(Person person){
        return repository.save(person);
    }

    public Person editPerson(Long id, Person person2){
        person = getPersonById(id);
        person.setId(id);
        person.setName(person2.getName());
        person.setLastName(person2.getLastName());
        person.setPhone(person2.getPhone());
        return person;
    }

    public void deletePersonById(Long id){
        repository.deleteById(id);
    }
}
