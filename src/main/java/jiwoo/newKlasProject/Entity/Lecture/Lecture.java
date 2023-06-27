package jiwoo.newKlasProject.Entity.Lecture;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jiwoo.newKlasProject.DTO.Lecture.LectureDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="lecture")
public class Lecture {
    @Id
    private String lnum;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String classification;
    @Column(nullable = false)
    private int lyear;
    @Column(nullable = false)
    private int lsemester;
    @Column(nullable = false)
    private String lroom;
    @Column(nullable = false)
    private String pid;
    @Column(nullable = false)
    private String pname;
    @Column(nullable = false)
    private int enroll;
    @Column
    private int cur_enroll;
    @Column
    private String linfo;
    @Column
    private String obj_method;
    @Builder
    public Lecture(String lnum, String name, String classfication, int lyear, int lsemester, String lroom, String pid, String pname, int enroll, String linfo, String obj_method) {
        this.lnum = lnum;
        this.name = name;
        this.classification = classfication;
        this.lyear = lyear;
        this.lsemester = lsemester;
        this.lroom = lroom;
        this.pid = pid;
        this.pname = pname;
        this.enroll = enroll;
        this.cur_enroll = 0;
        this.linfo = linfo;
        this.obj_method = obj_method;
    }

    public void update(LectureDTO lectureDTO) {
        this.lnum = lectureDTO.getLnum();
        this.name = lectureDTO.getName();
        this.classification = lectureDTO.getClassification();
        this.lyear = lectureDTO.getLyear();
        this.lsemester = lectureDTO.getLsemester();
        this.lroom = lectureDTO.getLroom();
        this.pid = lectureDTO.getPid();
        this.pname = lectureDTO.getPname();
        this.enroll = lectureDTO.getEnroll();
        this.linfo = lectureDTO.getLinfo();
        this.obj_method = lectureDTO.getObj_method();
    }

}
