package se.lexicon.g55springbootlecture;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g55springbootlecture.domain.entity.Address;
import se.lexicon.g55springbootlecture.domain.entity.Student;
import se.lexicon.g55springbootlecture.repository.AddressRepository;
import se.lexicon.g55springbootlecture.repository.StudentRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private StudentRepository studentRepo;
    private AddressRepository addressRepo;

    @Autowired
    public MyCommandLineRunner(StudentRepository studentRepo, AddressRepository addressRepo) {
        this.studentRepo = studentRepo;
        this.addressRepo = addressRepo;
    }

    @Override
    // This ensures that if something goes wrong, only one part will be sent to the database.
    // So if something went wrong nothing will be sent to the database.
    @Transactional(rollbackOn = {Exception.class, RuntimeException.class})
    public void run(String... args) throws Exception {
    /*
        System.out.println("###### Application started successfully ######");
        Address address = new Address("Main Street", "Gothenburg", "41101");
        //addressRepo.save(address);

        //if(true) throw new RuntimeException("This is a test: something went wrong");
        // @Transactional will rollback the transaction if an exception occurs

        Student student1 = new Student("John", "Doe", "JohnDoe@test.com");
        student1.setAddress(address); // link address to student
        Student createdStudent = studentRepo.save(student1);

        System.out.printf("Student created: %s\n", createdStudent);

        studentRepo.delete(createdStudent);
        */
    }
}
