package jiwoo.newKlasProject.DTO.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureAssignmentDTO {
    private Long id;
    private String lnum;
    private String title;
    private String contents;
    private LocalDateTime startdate;
    private LocalDateTime duedate;
}
