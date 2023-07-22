package jiwoo.newKlasProject.Entity.Lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureStudentID implements Serializable {
    private String sid;
    private String lnum;
}
