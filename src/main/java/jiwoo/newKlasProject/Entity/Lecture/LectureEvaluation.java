package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.Lecture.LectureEvaluationDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "lecture_evaluation")
public class LectureEvaluation {
    @Id
    private String lnum;
    @ColumnDefault("0")
    private int attendance;
    @ColumnDefault("0")
    private int midterm;
    @ColumnDefault("0")
    private int finalterm;
    @ColumnDefault("0")
    private int assignment;
    @ColumnDefault("0")
    private int attitude;
    @ColumnDefault("0")
    private int quiz;

    @Builder
    public LectureEvaluation(String lnum) {
        this.lnum = lnum;
    }

    public void update(LectureEvaluationDTO lectureEvaluationDTO) {
        this.lnum = lectureEvaluationDTO.getLnum();
        this.attendance = lectureEvaluationDTO.getAttendance();
        this.midterm = lectureEvaluationDTO.getMidterm();
        this.finalterm = lectureEvaluationDTO.getFinalterm();
        this.assignment = lectureEvaluationDTO.getAssignment();
        this.attitude = lectureEvaluationDTO.getAttitude();
        this.quiz = lectureEvaluationDTO.getQuiz();
    }

}
