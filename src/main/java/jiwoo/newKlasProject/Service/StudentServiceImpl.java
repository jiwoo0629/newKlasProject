package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.Entity.Student;
import jiwoo.newKlasProject.DTO.StudentDTO;
import jiwoo.newKlasProject.Entity.User;
import jiwoo.newKlasProject.Repository.StudentRepository;
import jiwoo.newKlasProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    @Override
    public Student findByIdName(String sid, String name) {
        Student student = studentRepository.findBySidName(sid, name)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return student;
    }
    @Override
    public String findBySidNameBirth(String sid, String name, LocalDate birth) {
        String id = studentRepository.findBySidNameBirth(sid, name, birth)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return id;
    }
    @Override
    public Student findByNameDep(String name, String dep) {
        String id = studentRepository.findByNameDep(name, dep);
        if(id == null) return null;
        Student student = studentRepository.findByUser_Id(id);
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
        if(studentRepository.findBySid(studentDTO.getSid()).isPresent())
            throw new IllegalArgumentException("ALREADY_EXIST");
        User user = User.builder()
                .id(studentDTO.getSid())
                .password("00000000")
                .role("stud")
                .build();
        userRepository.save(user);
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
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        student.update(studentDTO);
        studentRepository.save(student);
    }
    @Override
    public void deleteStudent(String sid) {
        studentRepository.deleteById(sid);
    }
}
