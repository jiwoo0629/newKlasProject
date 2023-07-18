package jiwoo.newKlasProject.Repository.Lecture;

import jiwoo.newKlasProject.Entity.Lecture.LectureAnnouncement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LectureAnnouncementRepository extends JpaRepository<LectureAnnouncement, Long> {
    Optional<LectureAnnouncement> findByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
    Optional<List<LectureAnnouncement>> findAllByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureAnnouncement l where l.lnum = :lnum")
    void deleteByLnum(@Param("lnum") String lnum);
    @Query("delete from LectureAnnouncement l where l.id = :id and l.lnum = :lnum")
    void deleteByIdLnum(@Param("id") Long id, @Param("lnum") String lnum);
}
