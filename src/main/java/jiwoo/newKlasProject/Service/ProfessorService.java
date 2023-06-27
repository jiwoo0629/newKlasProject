package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.ProfessorDTO;
import jiwoo.newKlasProject.Entity.Professor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProfessorService {
    Professor getProfessor(String pid, String name);
    List<Professor> getAllProfessor();
    void enrollProfessor(ProfessorDTO professorDTO);
    void updateProfessor(ProfessorDTO professorDTO);
    void deleteProfessor(String pid);
}
