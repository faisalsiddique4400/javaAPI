package com.example.demo.DAO;

import com.example.demo.Model.Person;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, Person person);
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return  insertPerson(id, person);
    }

    List<Person> getAllData();
    Optional<Person> getPersonById(UUID id);
    int deletePersonById(UUID id);
    int updatePersonById(UUID id, Person person);

    Person deletePerson(UUID id);
}
