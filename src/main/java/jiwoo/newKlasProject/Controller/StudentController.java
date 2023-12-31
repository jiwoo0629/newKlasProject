package jiwoo.newKlasProject.Controller;

import jiwoo.newKlasProject.DTO.StudentDTO;
import jiwoo.newKlasProject.Entity.Student;
import jiwoo.newKlasProject.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/findByIdName")
    public ResponseEntity<Student> findByIdName(@RequestParam("sid") String sid, @RequestParam("name") String name) {
        Student student = studentService.findByIdName(sid, name);
        return ResponseEntity.ok().body(student);
    }
    @GetMapping("/findByIdNameBirth")
    public ResponseEntity<String> findBySidNameBirth(@RequestParam("sid") String sid, @RequestParam("name") String name, @RequestParam("birth") String birth) {
        LocalDate date = LocalDate.ofInstant(Instant.parse(birth), ZoneId.of(ZoneOffset.UTC.getId()));
        String id = studentService.findBySidNameBirth(sid, name, date);
        return ResponseEntity.ok().body(id);
    }
    @GetMapping("/findByNameDep")
    public ResponseEntity<?> findByNameDep(@RequestParam("name") String name, @RequestParam("dep") String dep) {
        Student student = studentService.findByNameDep(name, dep);
        return ResponseEntity.ok().body(student);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();
        return ResponseEntity.ok().body(studentList);
    }
    @PostMapping("/enroll")
    public ResponseEntity<HttpStatus> enrollStudent(@RequestBody StudentDTO studentDTO) {
        studentService.enrollStudent(studentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateStudent(@RequestBody StudentDTO studentDTO) {
        studentService.updateStudent(studentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteStudent(@RequestParam("sid") String sid) {
        studentService.deleteStudent(sid);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
