package jiwoo.newKlasProject.Entity.Lecture;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.Lecture.LectureTimeDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_time")
public class LectureTime {
    @Id
    private String lnum;
    @Column(nullable = false)
    private String lt1_day;
    @Column(nullable = false)
    private int lt1_time;
    @Column
    private String lt2_day;
    @Column
    private int lt2_time;

    @Builder
    public LectureTime(String lnum, String lt1_day, int lt1_time, String lt2_day, int lt2_time) {
        this.lnum = lnum;
        this.lt1_day = lt1_day;
        this.lt1_time = lt1_time;
        this.lt2_day = lt2_day;
        this.lt2_time = lt2_time;
    }
    public void update(LectureTimeDTO lectureTimeDTO) {
        this.lnum = lectureTimeDTO.getLnum();
        this.lt1_day = lectureTimeDTO.getLt1_day();
        this.lt1_time = lectureTimeDTO.getLt1_time();
        this.lt2_day = lectureTimeDTO.getLt2_day();
        this.lt2_time = lectureTimeDTO.getLt2_time();
    }
    @JsonIgnore
    @OneToOne
    @JoinColumn(name="lnum")
    private Lecture lecture;
}
