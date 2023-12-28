package ie.atu.week7app;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void savePerson(Person person){
        personRepository.save(person);


    }

    public Person getPersonByEmployeeId(String employeeId){


        return new Person();
    }

}
