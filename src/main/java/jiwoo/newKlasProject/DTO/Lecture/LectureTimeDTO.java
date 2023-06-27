package jiwoo.newKlasProject.DTO.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureTimeDTO {
    private String lnum;
    private String lt1_day;
    private int lt1_time;
    private String lt2_day;
    private int lt2_time;
}
