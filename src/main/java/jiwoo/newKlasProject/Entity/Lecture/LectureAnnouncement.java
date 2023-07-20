package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.Lecture.LectureAnnouncementDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_announcement")
public class LectureAnnouncement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lnum;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private LocalDateTime date;

    @Builder
    public LectureAnnouncement(String lnum, String title, String contents, String writer, LocalDateTime date) {
        this.lnum = lnum;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.date = date;
    }
    public void update(LectureAnnouncementDTO lectureAnnouncementDTO) {
        this.lnum = lectureAnnouncementDTO.getLnum();
        this.title = lectureAnnouncementDTO.getTitle();
        this.contents = lectureAnnouncementDTO.getContents();
        this.writer = lectureAnnouncementDTO.getWriter();
        this.date = lectureAnnouncementDTO.getDate();
    }

}
