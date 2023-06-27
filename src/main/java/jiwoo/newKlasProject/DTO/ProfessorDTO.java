package jiwoo.newKlasProject.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDTO {
    private String pid;
    private String name;
    private String dep;
    private String lab;
    private char sex;
    private String phone;
    private String email;
    private LocalDate birth;
}
