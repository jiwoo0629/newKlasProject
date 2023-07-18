package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jiwoo.newKlasProject.DTO.Lecture.LectureScheduleDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_schedule")
public class LectureSchedule {
    @Id
    private String lnum;
    @Id
    private int week;
    @Column
    private String contents;
    @Column
    private String method;
    @Builder
    public LectureSchedule(String lnum, int week) {
        this.lnum = lnum;
        this.week = week;
    }
    public void update (LectureScheduleDTO lectureScheduleDTO) {
        this.lnum = lectureScheduleDTO.getLnum();
        this.week = lectureScheduleDTO.getWeek();
        this.contents = lectureScheduleDTO.getContents();
        this.method = lectureScheduleDTO.getMethod();
    }
}
