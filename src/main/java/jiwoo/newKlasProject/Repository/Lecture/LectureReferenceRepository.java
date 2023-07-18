package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureReference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureReferenceRepository extends JpaRepository<LectureReference, Long> {
    Optional<LectureReference> findByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
    Optional<List<LectureReference>> findAllByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureReference l where l.lnum = :lnum")
    void deleteByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureReference l where l.id = :id and l.lnum = :lnum")
    void deleteByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
}
