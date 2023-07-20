package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureAskAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureAskAnswerRepository extends JpaRepository<LectureAskAnswer, Long> {
    @Query("select l from LectureAskAnswer l where l.id = :id and l.lnum = :lnum")
    Optional<LectureAskAnswer> findByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
    Optional<List<LectureAskAnswer>> findAllByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureAskAnswer l where l.lnum = :lnum")
    void deleteByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureAskAnswer l where l.id = :id and l.lnum = :lnum")
    void deleteByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
}
