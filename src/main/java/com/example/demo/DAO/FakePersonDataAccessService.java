package com.example.demo.DAO;

import com.example.demo.Model.Person;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> personList = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        personList.add(new Person(person.getName(), id));
        return 1;
    }

    @Override
    public List<Person> getAllData() {
        return personList;
    }

    @Override
    public Optional<Person> getPersonById(UUID id) {
        return personList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Person> person = getPersonById(id);
        if (person != null) {
            personList.remove(person);
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        Person p=getPersonById(id).orElse(null);
        int indexToDelete=personList.indexOf(p);
        if(p!=null){
            UUID deletedPersonsId=p.getId();
            personList.remove(indexToDelete);
            person.setId(deletedPersonsId);
            personList.add(indexToDelete,person);
            return 1;
        }else {
            return 0;
        }

    }

    @Override
    public Person deletePerson(UUID id) {
        Optional<Person> p = getPersonById(id);
        if(p.isPresent()){
            personList.remove(p.get());
            return p.get();
        }
        return null;
    }

}
