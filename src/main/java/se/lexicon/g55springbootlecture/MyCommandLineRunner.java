package se.lexicon.g55springbootlecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g55springbootlecture.domain.entity.Student;
import se.lexicon.g55springbootlecture.repository.StudentRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private StudentRepository studentRepo;

    @Autowired
    public MyCommandLineRunner(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("###### Application started successfully ######");
        Student student1 = new Student("John", "Doe", "JohnDoe@test.com");
        Student createdStudent = studentRepo.save(student1);
        System.out.printf("Student created: %s\n", createdStudent);
    }
}
