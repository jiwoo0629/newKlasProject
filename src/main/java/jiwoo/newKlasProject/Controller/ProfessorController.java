package jiwoo.newKlasProject.Controller;

import jiwoo.newKlasProject.DTO.ProfessorDTO;
import jiwoo.newKlasProject.Entity.Professor;
import jiwoo.newKlasProject.Service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;
    @GetMapping("/findByIdName")
    public ResponseEntity<Professor> findByIdName(@RequestParam("pid") String pid, @RequestParam("name") String name) {
        Professor professor = professorService.findByIdName(pid, name);
        return ResponseEntity.ok().body(professor);
    }
    @GetMapping("/findByNameDep")
    public ResponseEntity<?> findByNameDep(@RequestParam("name") String name, @RequestParam("dep") String dep) {
        Professor professor = professorService.findByNameDep(name, dep);
        return ResponseEntity.ok().body(professor);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Professor>> getAllProfessor() {
        List<Professor> professorList = professorService.getAllProfessor();
        return ResponseEntity.ok().body(professorList);
    }
    @PostMapping("/enroll")
    public ResponseEntity<HttpStatus> enrollProfessor(@RequestBody ProfessorDTO professorDTO) {
        professorService.enrollProfessor(professorDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateProfessor(@RequestBody ProfessorDTO professorDTO) {
        professorService.updateProfessor(professorDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteProfessor(@RequestParam("pid") String pid) {
        professorService.deleteProfessor(pid);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
