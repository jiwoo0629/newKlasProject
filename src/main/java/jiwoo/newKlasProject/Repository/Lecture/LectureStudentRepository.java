package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureStudent;
import jiwoo.newKlasProject.Entity.Lecture.LectureStudentID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureStudentRepository extends JpaRepository<LectureStudent, LectureStudentID> {
    Optional<List<LectureStudent>> findByLnum(@Param("lnum") String lnum);
    Optional<List<LectureStudent>> findBySid(@Param("sid") String sid);
    @Query("select l from LectureStudent l where l.sid=:sid and l.lnum=:lnum")
    Optional<LectureStudent> findBySidLnum(@Param("sid") String sid, @Param("lnum") String lnum);
    @Query("delete from LectureStudent l where l.sid=:sid and l.lnum=:lnum")
    void deleteBySidLnum(@Param("sid") String sid, @Param("lnum") String lnum);
}
