package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.Lecture.*;
import jiwoo.newKlasProject.Entity.Lecture.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LectureService {
    Lecture getLecture(String lnum, String name);
    List<Lecture> getAllLecture();
    LectureTime getLectureTime(String lnum);
    LectureEvaluation getLectureEvaluation(String lnum);
    LectureSchedule getLectureSchedule(String lnum);
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
    void enrollLectureTime(LectureTimeDTO lectureTimeDTO);
    void enrollLectureEvaluation(String lnum);
    void enrollLectureSchedule(String lnum, int week);
    void enrollLectureAnnouncement(LectureAnnouncementDTO lectureAnnouncementDTO);
    void enrollLectureReference(LectureReferenceDTO lectureReferenceDTO);
    void enrollLectureAskAnswer(LectureAskAnswerDTO lectureAskAnswerDTO);
    void enrollLectureAskAnswerComment(LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO);
    void enrollLectureAssignment(LectureAssignmentDTO lectureAssignmentDTO);
    void updateLecture(LectureDTO lectureDTO);
    void updateLectureTime(LectureTimeDTO lectureTimeDTO);
    void updateLectureEvaluation(LectureEvaluationDTO lectureEvaluationDTO);
    void updateLectureSchedule(LectureScheduleDTO lectureScheduleDTO);
    void updateLectureAnnouncement(LectureAnnouncementDTO lectureAnnouncementDTO);
    void updateLectureReference(LectureReferenceDTO lectureReferenceDTO);
    void updateLectureAskAnswer(LectureAskAnswerDTO lectureAskAnswerDTO);
    void updateLectureAskAnswerComment(LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO);
    void updateLectureAssignment(LectureAssignmentDTO lectureAssignmentDTO);
    void deleteLecture(String lnum);
    void deleteLectureAnnouncement(Long id, String lnum);
    void deleteLectureReference(Long id, String lnum);
    void deleteLectureAskAnswer(Long id, String lnum);
    void deleteLectureAskAnswerComment(Long comid, Long id, String lnum);
    void deleteLectureAssignment(Long id, String lnum);
}
