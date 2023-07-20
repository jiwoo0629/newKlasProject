package jiwoo.newKlasProject.Entity;

import jakarta.persistence.*;
import jiwoo.newKlasProject.DTO.StudentDTO;
import jiwoo.newKlasProject.Entity.Lecture.LectureStudent;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="student")
public class Student {
    @Id @Column(name="sid")
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
    @OneToOne
    @JoinColumn(name="sid", referencedColumnName="id")
    private User user;

    @Builder
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
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="sid_lecturestudent", referencedColumnName="sid")
    private List<LectureStudent> lectureStudent = new ArrayList<>();
}
