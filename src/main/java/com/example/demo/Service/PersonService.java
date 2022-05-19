package com.example.demo.Service;

import com.example.demo.DAO.PersonDao;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAllData(){
        return personDao.getAllData();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.getPersonById(id);
    }

    public int updatePersonById(UUID id, Person p){
        return personDao.updatePersonById(id,p);
    }

    public Person deletePerson(UUID id){
        return personDao.deletePerson(id);
    }
}
