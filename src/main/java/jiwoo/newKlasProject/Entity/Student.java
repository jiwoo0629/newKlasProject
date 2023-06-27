package jiwoo.newKlasProject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jiwoo.newKlasProject.DTO.StudentDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Entity
@Getter
@NoArgsConstructor
@Table(name="student")
public class Student {
    @Id
    private String sid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String dep;
    @Column(nullable = false)
    private int grade;
    @Column
    private char sex;
    @Column
    private LocalDate birth;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private String addr;
    public Student(String sid, String name, String dep, int grade, char sex, LocalDate birth, String phone, String email, String addr) {
        this.sid = sid;
        this.name = name;
        this.dep = dep;
        this.grade = grade;
        this.sex = sex;
        this.birth = birth;
        this.phone = (phone.equals("")) ? "" : phone;
        this.email = (email.equals("")) ? "" : email;
        this.addr = (addr.equals("")) ? "" : addr;
    }

    public void update(StudentDTO studentDTO) {
        this.sid = studentDTO.getSid();
        this.name = studentDTO.getName();
        this.dep = studentDTO.getDep();
        this.grade = studentDTO.getGrade();
        this.sex = studentDTO.getSex();
        this.birth = studentDTO.getBirth();
        this.phone = studentDTO.getPhone();
        this.email = studentDTO.getEmail();
        this.addr = studentDTO.getAddr();
    }
}
