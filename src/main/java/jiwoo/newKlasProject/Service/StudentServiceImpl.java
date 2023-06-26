package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.Entity.Student;
import jiwoo.newKlasProject.DTO.StudentDTO;
import jiwoo.newKlasProject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student getStudent(String sid) {
        Student student = studentRepository.findBySid(sid)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return student;
    }
    @Override
    public List<Student> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        if(studentList.isEmpty())
            throw new IllegalArgumentException("NO_DATA");
        return studentList;
    }
    @Override
    public void enrollStudent(StudentDTO studentDTO) {
        if(studentRepository.findByName(studentDTO.getName()).isPresent())
            throw new IllegalArgumentException("ALREADY_EXIST");
        Student student = Student.builder()
                .sid(studentDTO.getSid())
                .name(studentDTO.getName())
                .dep(studentDTO.getDep())
                .grade(studentDTO.getGrade())
                .sex(studentDTO.getSex())
                .birth(studentDTO.getBirth())
                .phone(studentDTO.getPhone())
                .email(studentDTO.getEmail())
                .addr(studentDTO.getAddr())
                .build();
        studentRepository.save(student);
    }
    @Override
    public void updateStudent(StudentDTO studentDTO) {
        Student student = studentRepository.findBySid(studentDTO.getSid())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));;
        student.update(studentDTO);
        studentRepository.save(student);
    }
    @Override
    public void deleteStudent(String sid) {
        studentRepository.deleteById(sid);
    }
}
