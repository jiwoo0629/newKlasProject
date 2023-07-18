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
public class LectureReferenceDTO {
    private Long id;
    private String lnum;
    private String title;
    private String contents;
    private String writer;
    private LocalDateTime date;
}
