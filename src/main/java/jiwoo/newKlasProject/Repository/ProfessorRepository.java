package jiwoo.newKlasProject.Repository;

import jiwoo.newKlasProject.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Optional<Professor> findByPid(String pid);
    @Query("select p from Professor p where p.pid = :pid and p.name = :name")
    Optional<Professor> findByPidName(@Param("pid") String pid, @Param("name") String name);
}