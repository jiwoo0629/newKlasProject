package jiwoo.newKlasProject.DTO.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureDTO {
    private String lnum;
    private String name;
    private String classification;
    private int lyear;
    private int lsemester;
    private String lroom;
    private String pid;
    private String pname;
    private int enroll;
    private String linfo;
    private String obj_method;
}
