package Sathish292004.JDBC.service;

import Sathish292004.JDBC.Repo.StudentRepo;
import Sathish292004.JDBC.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student std){
        repo.save(std);

    }

    public List<Student> getStudent() {
        return repo.findAll();
    }
}
