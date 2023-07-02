package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.ProfessorDTO;
import jiwoo.newKlasProject.Entity.Professor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface ProfessorService {
    Professor findByIdName(String pid, String name);
    String findByIdNameBirth(String pid, String name, LocalDate birth);
    Professor findByNameDep(String name, String dep);
    List<Professor> getAllProfessor();
    void enrollProfessor(ProfessorDTO professorDTO);
    void updateProfessor(ProfessorDTO professorDTO);
    void deleteProfessor(String pid);
}
