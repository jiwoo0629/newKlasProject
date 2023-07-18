package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jiwoo.newKlasProject.DTO.Lecture.LectureReferenceDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_reference")
public class LectureReference {
    @Id
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
    public LectureReference(String lnum, String title, String contents, String writer, LocalDateTime date) {
        this.lnum = lnum;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.date = date;
    }
    public void update(LectureReferenceDTO lectureReferenceDTO) {
        this.lnum = lectureReferenceDTO.getLnum();
        this.title = lectureReferenceDTO.getTitle();
        this.contents = lectureReferenceDTO.getContents();
        this.writer = lectureReferenceDTO.getWriter();
        this.date = lectureReferenceDTO.getDate();
    }
}
