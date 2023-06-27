package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LectureRepository extends JpaRepository<Lecture, String> {
    Optional<Lecture> findByLnum(@Param("lnum") String lnum);
    @Query("select l from Lecture l where lnum = :lnum and name = :name")
    Optional<Lecture> findByLnumName(@Param("lnum") String lnum, @Param("name") String name);
}
