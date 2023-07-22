package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture_student")
@IdClass(LectureStudentID.class)
public class LectureStudent implements Serializable {
    @Id
    private String sid;
    @Id
    private String lnum;
    @Column(nullable=false)
    private int lyear;
    @Column(nullable=false)
    private int lsemester;
    @Builder
    public LectureStudent(String lnum, int lyear, int lsemester, String sid) {
        this.lnum = lnum;
        this.lyear = lyear;
        this.lsemester = lsemester;
        this.sid = sid;
    }
}
