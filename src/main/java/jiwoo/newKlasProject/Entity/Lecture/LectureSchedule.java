package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.Lecture.LectureScheduleDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_schedule")
@IdClass(LectureScheduleID.class)
public class LectureSchedule implements Serializable {
    @Id
    private String lnum;
    @Id
    private Long week;
    @Column
    private String contents;
    @Column
    private String method;
    @Builder
    public LectureSchedule(String lnum, Long week) {
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
