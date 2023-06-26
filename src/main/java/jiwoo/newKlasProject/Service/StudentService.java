package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.Entity.Student;
import jiwoo.newKlasProject.DTO.StudentDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {
    Student getStudent(String sid);
    List<Student> getAllStudent();
    void enrollStudent(StudentDTO studentDTO);
    void updateStudent(StudentDTO studentDTO);
    void deleteStudent(String sid);
}
