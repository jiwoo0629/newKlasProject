package jiwoo.newKlasProject.DTO.Lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LectureAskAnswerCommentDTO {
    private String lnum;
    private Long id;
    private String contents;
    private String writer;
}
