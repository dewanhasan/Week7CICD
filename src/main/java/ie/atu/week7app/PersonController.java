package ie.atu.week7app;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService =personService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getPerson(@PathVariable String employeeId){
        if(employeeId.length() > 5 || employeeId.isBlank()){
            return ResponseEntity.badRequest().body("EmployeeId is Invalid");
        }

        Person person = personService.getPersonByEmployeeId(employeeId);

        if(person == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(person);
    }

    @PostMapping("createPerson")
    public ResponseEntity<String>create(@Valid @RequestBody Person person){
        personService.savePerson(person);
        return new ResponseEntity<>("Person Created Succesfully", HttpStatus.OK);
    }

}
