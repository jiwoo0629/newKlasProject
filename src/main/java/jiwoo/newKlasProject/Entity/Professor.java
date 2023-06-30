package jiwoo.newKlasProject.Entity;

import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.ProfessorDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Getter
@NoArgsConstructor
@Table(name="professor")
public class Professor {
    @Id @Column(name="pid")
    private String pid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String dep;
    @Column(nullable = false)
    private String lab;
    @Column
    private char sex;
    @Column
    private String phone;
    @Column
    private String email;
    @Column
    private LocalDate birth;
    @OneToOne
    @JoinColumn(name="pid", referencedColumnName = "id")
    private User user;

    @Builder
    public Professor(String pid, String name, String dep, String lab, char sex, String phone, String email, LocalDate birth) {
        this.pid = pid;
        this.name = name;
        this.dep = dep;
        this.lab = lab;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.birth = birth;
    }
    public void update(ProfessorDTO professorDTO) {
        this.pid = professorDTO.getPid();
        this.name = professorDTO.getName();
        this.dep = professorDTO.getDep();
        this.lab = professorDTO.getLab();
        this.sex = professorDTO.getSex();
        this.phone = professorDTO.getPhone();
        this.email = professorDTO.getEmail();
        this.birth = professorDTO.getBirth();
    }
}
