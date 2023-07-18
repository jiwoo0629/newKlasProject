package jiwoo.newKlasProject.DTO.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureEvaluationDTO {
    private String lnum;
    private int attendance;
    private int midterm;
    private int finalterm;
    private int assignment;
    private int attitude;
    private int quiz;
}
