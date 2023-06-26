package jiwoo.newKlasProject.Controller;

import jiwoo.newKlasProject.DTO.StudentDTO;
import jiwoo.newKlasProject.Entity.Student;
import jiwoo.newKlasProject.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam("sid") String sid) {
        Student student = studentService.getStudent(sid);
        return ResponseEntity.ok().body(student);
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
