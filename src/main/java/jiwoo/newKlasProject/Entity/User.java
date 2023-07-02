package jiwoo.newKlasProject.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="user")
public class User {
    @Id @Column(name="id")
    String id;
    @Column(nullable = false)
    String password;
    @Column(nullable = false)
    String role;
    @Builder
    public User(String id, String password, String role) {
        this.id=id;
        this.password=password;
        this.role=role;
    }
    public void resetPW() {
        this.password="00000000";
    }
    @JsonIgnore @OneToOne(mappedBy="user", fetch=FetchType.LAZY)
    private Student student;
    @JsonIgnore @OneToOne(mappedBy="user", fetch=FetchType.LAZY)
    private Professor professor;
}
