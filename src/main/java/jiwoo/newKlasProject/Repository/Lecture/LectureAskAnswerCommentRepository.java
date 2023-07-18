package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureAskAnswerComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureAskAnswerCommentRepository extends JpaRepository<LectureAskAnswerComment, Long> {
    Optional<LectureAskAnswerComment> findByComidIdLnum(@Param("comid") Long comid, @Param("id") Long id, @Param("lnum") String lnum);
    Optional<List<LectureAskAnswerComment>> findAllByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
    @Query("delete from LectureAskAnswerComment l where l.id = :id and l.lnum = :lnum")
    void deleteByIdLnum(@Param("lnum") String lnum);
    @Query("delete from LectureAskAnswerComment l where l.comid = :comid and l.id = :id and l.lnum = :lnum")
    void deleteByComidIdLnum(@Param("comid") Long comid, @Param("id") Long id, @Param("lnum") String lnum);

}
