package jiwoo.newKlasProject.Entity.Lecture;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.Lecture.LectureAskAnswerDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_askanswer")
public class LectureAskAnswer {
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
    public LectureAskAnswer(String lnum, String title, String contents, String writer, LocalDateTime date) {
        this.lnum = lnum;
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.date = date;
    }
    public void update(LectureAskAnswerDTO lectureAskAnswerDTO) {
        this.lnum = lectureAskAnswerDTO.getLnum();
        this.title = lectureAskAnswerDTO.getTitle();
        this.contents = lectureAskAnswerDTO.getContents();
        this.writer = lectureAskAnswerDTO.getWriter();
        this.date = lectureAskAnswerDTO.getDate();
    }

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name="lnum_comment", referencedColumnName = "lnum"),
            @JoinColumn(name="id_comment", referencedColumnName = "id")
    })
    private List<LectureAskAnswerComment> commentList = new ArrayList<>();
}
