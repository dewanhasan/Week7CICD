package ie.atu.week7app;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public void savePerson(Person person){
        System.out.println("Person saved: " + person);
    }

    public Person getPersonByEmployeeId(String employeeId){
        return new Person();
    }

}
