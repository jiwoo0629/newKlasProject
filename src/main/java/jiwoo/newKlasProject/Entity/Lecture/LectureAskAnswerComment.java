package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.Lecture.LectureAskAnswerCommentDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_askanswer_comment")
public class LectureAskAnswerComment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comid;
    @Column(nullable = false)
    private String lnum;
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private LocalDateTime date;

    @Builder
    public LectureAskAnswerComment(String lnum, Long id, String contents, String writer) {
        this.lnum = lnum;
        this.id = id;
        this.contents = contents;
        this.writer = writer;
        this.date = new java.sql.Timestamp(new Date().getTime()).toLocalDateTime();
    }
    public void update(LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO) {
        this.lnum = lectureAskAnswerCommentDTO.getLnum();
        this.id = lectureAskAnswerCommentDTO.getId();
        this.contents = lectureAskAnswerCommentDTO.getContents();
        this.writer = lectureAskAnswerCommentDTO.getWriter();
        this.date = new java.sql.Timestamp(new Date().getTime()).toLocalDateTime();
    }

}
