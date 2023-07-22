package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureSchedule;
import jiwoo.newKlasProject.Entity.Lecture.LectureScheduleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureScheduleRepository extends JpaRepository<LectureSchedule, LectureScheduleID> {
    @Query("select l from LectureSchedule l where l.lnum = :lnum")
    Optional<List<LectureSchedule>> findByLnum(@Param("lnum") String lnum);
}
