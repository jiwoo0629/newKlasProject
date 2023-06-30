package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.ProfessorDTO;
import jiwoo.newKlasProject.Entity.Professor;
import jiwoo.newKlasProject.Entity.User;
import jiwoo.newKlasProject.Repository.ProfessorRepository;
import jiwoo.newKlasProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{
    private final ProfessorRepository professorRepository;
    private final UserRepository userRepository;
    @Override
    public Professor findByIdName(String pid, String name) {
        Professor professor = professorRepository.findByPidName(pid, name)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return professor;
    }
    @Override
    public Professor findByNameDep(String name, String dep) {
        String id = professorRepository.findByNameDep(name, dep);
        if(id == null) return null;
        Professor professor = professorRepository.findByUser_Id(id);
        return professor;
    }
    @Override
    public List<Professor> getAllProfessor() {
        List<Professor> professorList = professorRepository.findAll();
        return professorList;
    }
    @Override
    public void enrollProfessor(ProfessorDTO professorDTO) {
        if(professorRepository.findByPid(professorDTO.getPid()).isPresent())
            throw new IllegalArgumentException("ALREADY_EXISTS");
        User user = User.builder()
                .id(professorDTO.getPid())
                .password("00000000")
                .role("prof")
                .build();
        userRepository.save(user);
        Professor professor = Professor.builder()
                .pid(professorDTO.getPid())
                .name(professorDTO.getName())
                .dep(professorDTO.getDep())
                .lab(professorDTO.getLab())
                .sex(professorDTO.getSex())
                .phone(professorDTO.getPhone())
                .email(professorDTO.getEmail())
                .birth(professorDTO.getBirth())
                .build();
        professorRepository.save(professor);
    }
    @Override
    public void updateProfessor(ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findByPid(professorDTO.getPid())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        professor.update(professorDTO);
        professorRepository.save(professor);
    }
    @Override
    public void deleteProfessor(String pid) {
        professorRepository.deleteById(pid);
    }
}
