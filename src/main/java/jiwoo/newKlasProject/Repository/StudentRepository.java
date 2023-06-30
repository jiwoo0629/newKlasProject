package jiwoo.newKlasProject.Repository;

import jiwoo.newKlasProject.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findBySid(String sid);
    Student findByUser_Id(String id);
    @Query(value = "select s from Student s where s.sid = :sid and s.name = :name")
    Optional<Student> findBySidName(@Param("sid") String sid, @Param("name") String name);
    @Query(value = "select s.sid from Student s where s.name = :name and s.dep = :dep")
    String findByNameDep(@Param("name") String name, @Param("dep") String dep);
}
