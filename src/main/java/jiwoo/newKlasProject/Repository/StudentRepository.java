package jiwoo.newKlasProject.Repository;

import jiwoo.newKlasProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findBySid(String sid);
    Optional<Student> findByName(String name);
}
