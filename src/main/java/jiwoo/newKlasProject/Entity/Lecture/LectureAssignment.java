package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.Lecture.LectureAssignmentDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_assignment")
public class LectureAssignment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String lnum;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private LocalDateTime duedate;

    @Builder
    public LectureAssignment(String lnum, String title, String contents, LocalDateTime duedate) {
        this.lnum = lnum;
        this.title = title;
        this.contents = contents;
        this.duedate = duedate;
    }
    public void update(LectureAssignmentDTO lectureAssignmentDTO) {
        this.lnum = lectureAssignmentDTO.getLnum();
        this.title = lectureAssignmentDTO.getTitle();
        this.contents = lectureAssignmentDTO.getContents();
        this.duedate = lectureAssignmentDTO.getDuedate();
    }

}
