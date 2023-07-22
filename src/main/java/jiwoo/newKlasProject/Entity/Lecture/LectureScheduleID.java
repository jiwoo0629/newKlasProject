package jiwoo.newKlasProject.Entity.Lecture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureScheduleID implements Serializable {
    private String lnum;
    private Long week;
}
