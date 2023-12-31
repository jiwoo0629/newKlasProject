package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureReferenceRepository extends JpaRepository<LectureReference, Long> {
    @Query("select l from LectureReference l where l.id = :id and l.lnum = :lnum")
    Optional<LectureReference> findByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
    List<LectureReference> findAllByLnum(@Param("lnum") String lnum);
}
