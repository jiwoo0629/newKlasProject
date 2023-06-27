package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LectureTimeRepository extends JpaRepository<LectureTime, String> {
    Optional<LectureTime> findByLnum(@Param("lnum") String lnum);
}
