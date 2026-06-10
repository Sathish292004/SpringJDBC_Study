package Sathish292004.JDBC;

import Sathish292004.JDBC.model.Student;
import Sathish292004.JDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJbdcApplication {

    public static void main(String[] args) {

       ApplicationContext context = SpringApplication.run(SpringJbdcApplication.class, args);

       Student std = context.getBean(Student.class);
       std.setRollNo(104);
       std.setName("Eren");
       std.setMark(85);

        StudentService service = context.getBean(StudentService.class);
        service.addStudent(std);

        List<Student> students =service.getStudent();
        System.out.println(students);


    }
}
