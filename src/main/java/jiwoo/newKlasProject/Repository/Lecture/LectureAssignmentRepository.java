package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureAssignmentRepository extends JpaRepository<LectureAssignment, Long> {
    @Query("select l from LectureAssignment l where l.id = :id and l.lnum = :lnum")
    Optional<LectureAssignment> findByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
    Optional<List<LectureAssignment>> findAllByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureAssignment l where l.lnum = :lnum")
    void deleteByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureAssignment l where l.id = :id and l.lnum = :lnum")
    void deleteByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
}
