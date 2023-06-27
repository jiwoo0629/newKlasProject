package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.Lecture.LectureDTO;
import jiwoo.newKlasProject.DTO.Lecture.LectureTimeDTO;
import jiwoo.newKlasProject.Entity.Lecture.Lecture;
import jiwoo.newKlasProject.Entity.Lecture.LectureTime;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LectureService {
    Lecture getLecture(String lnum, String name);
    List<Lecture> getAllLecture();
    LectureTime getLectureTime(String lnum);
    void enrollLecture(LectureDTO lectureDTO);
    void enrollLectureTime(LectureTimeDTO lectureTimeDTO);
    void updateLecture(LectureDTO lectureDTO);
    void updateLectureTime(LectureTimeDTO lectureTimeDTO);
    void deleteLecture(String lnum);
}
