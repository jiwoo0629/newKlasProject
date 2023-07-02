package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.Entity.Student;
import jiwoo.newKlasProject.DTO.StudentDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface StudentService {
    Student findByIdName(String sid, String name);
    String findBySidNameBirth(String sid, String name, LocalDate birth);
    Student findByNameDep(String name, String dep);
    List<Student> getAllStudent();
    void enrollStudent(StudentDTO studentDTO);
    void updateStudent(StudentDTO studentDTO);
    void deleteStudent(String sid);
}
