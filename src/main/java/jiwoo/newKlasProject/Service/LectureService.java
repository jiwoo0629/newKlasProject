package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.Lecture.*;
import jiwoo.newKlasProject.Entity.Lecture.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LectureService {
    Lecture getLecture(String lnum, String name);
    List<Lecture> getAllLecture();
    List<LectureStudent> getStudentByLnum(String lnum);
    List<LectureStudent> getLectureBySid(String sid);
    LectureTime getLectureTime(String lnum);
    LectureEvaluation getLectureEvaluation(String lnum);
    List<LectureSchedule> getLectureSchedule(String lnum);
    LectureAnnouncement getLectureAnnouncement(Long id, String lnum);
    List<LectureAnnouncement> getAllLectureAnnouncement(String lnum);
    LectureReference getLectureReference(Long id, String lnum);
    List<LectureReference> getAllLectureReference(String lnum);
    LectureAskAnswer getLectureAskAnswer(Long id, String lnum);
    List<LectureAskAnswer> getAllLectureAskAnswer(String lnum);
    LectureAskAnswerComment getLectureAskAnswerComment(Long comid, Long id, String lnum);
    List<LectureAskAnswerComment> getAllLectureAskAnswerComment(Long id, String lnum);
    LectureAssignment getLectureAssignment(Long id, String lnum);
    List<LectureAssignment> getAllLectureAssignment(String lnum);
    void enrollLecture(LectureDTO lectureDTO);
    void enrollStudent(LectureStudentDTO lectureStudentDTO);
    void enrollLectureTime(LectureTimeDTO lectureTimeDTO);
    void enrollLectureEvaluation(String lnum);
    void enrollLectureSchedule(String lnum, Long week);
    void enrollLectureAnnouncement(LectureAnnouncementDTO lectureAnnouncementDTO);
    void enrollLectureReference(LectureReferenceDTO lectureReferenceDTO);
    void enrollLectureAskAnswer(LectureAskAnswerDTO lectureAskAnswerDTO);
    void enrollLectureAskAnswerComment(LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO);
    void enrollLectureAssignment(LectureAssignmentDTO lectureAssignmentDTO);
    void updateLecture(LectureDTO lectureDTO);
    void updateLectureTime(LectureTimeDTO lectureTimeDTO);
    void updateLectureEvaluation(LectureEvaluationDTO lectureEvaluationDTO);
    void updateLectureSchedule(LectureScheduleDTO lectureScheduleDTO);
    void updateLectureAnnouncement(Long id, LectureAnnouncementDTO lectureAnnouncementDTO);
    void updateLectureReference(Long id, LectureReferenceDTO lectureReferenceDTO);
    void updateLectureAskAnswer(Long id, LectureAskAnswerDTO lectureAskAnswerDTO);
    void updateLectureAskAnswerComment(Long comid, LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO);
    void updateLectureAssignment(Long id, LectureAssignmentDTO lectureAssignmentDTO);
    void deleteLecture(String lnum);
    void deleteStudent(String sid, String lnum);
    void deleteLectureAnnouncement(Long id, String lnum);
    void deleteLectureReference(Long id, String lnum);
    void deleteLectureAskAnswer(Long id, String lnum);
    void deleteLectureAskAnswerComment(Long comid, Long id, String lnum);
    void deleteLectureAssignment(Long id, String lnum);
}
