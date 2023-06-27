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
public class StudentDTO {
    private String sid;
    private String name;
    private String dep;
    private int grade;
    private char sex;
    private LocalDate birth;
    private String phone;
    private String email;
    private String addr;
}
