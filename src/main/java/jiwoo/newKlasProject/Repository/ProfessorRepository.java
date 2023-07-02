package jiwoo.newKlasProject.Repository;

import jiwoo.newKlasProject.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Optional<Professor> findByPid(String pid);
    Professor findByUser_Id(String id);
    @Query("select p from Professor p where p.pid = :pid and p.name = :name")
    Optional<Professor> findByPidName(@Param("pid") String pid, @Param("name") String name);
    @Query("select p.pid from Professor p where p.pid = :pid and p.name = :name and p.birth = :birth")
    Optional<String> findByPidNameBirth(@Param("pid") String pid, @Param("name") String name, @Param("birth") LocalDate birth);
    @Query("select p.pid from Professor p where p.name = :name and p.dep = :dep")
    String findByNameDep(@Param("name") String name, @Param("dep") String dep);
}
