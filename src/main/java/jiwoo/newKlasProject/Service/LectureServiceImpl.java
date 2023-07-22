package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.Lecture.*;
import jiwoo.newKlasProject.Entity.Lecture.*;
import jiwoo.newKlasProject.Repository.Lecture.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService{
    private final LectureRepository lectureRepository;
    private final LectureStudentRepository lectureStudentRepository;
    private final LectureTimeRepository lectureTimeRepository;
    private final LectureEvaluationRepository lectureEvaluationRepository;
    private final LectureScheduleRepository lectureScheduleRepository;
    private final LectureAnnouncementRepository lectureAnnouncementRepository;
    private final LectureReferenceRepository lectureReferenceRepository;
    private final LectureAskAnswerRepository lectureAskAnswerRepository;
    private final LectureAskAnswerCommentRepository lectureAskAnswerCommentRepository;
    private final LectureAssignmentRepository lectureAssignmentRepository;
    @Override
    public Lecture getLecture(String lnum, String name) {
        Lecture lecture = lectureRepository.findByLnumName(lnum, name)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lecture;
    }
    @Override
    public List<Lecture> getAllLecture() {
        List<Lecture> lectureList = lectureRepository.findAll();
        return lectureList;
    }
    @Override
    public List<LectureStudent> getStudentByLnum(String lnum) {
        List<LectureStudent> studentList = lectureStudentRepository.findByLnum(lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return studentList;
    }
    @Override
    public List<LectureStudent> getLectureBySid(String sid) {
        List<LectureStudent> lectureList = lectureStudentRepository.findBySid(sid)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureList;
    }
    @Override
    public LectureTime getLectureTime(String lnum) {
        LectureTime lectureTime = lectureTimeRepository.findById(lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureTime;
    }
    @Override
    public LectureEvaluation getLectureEvaluation(String lnum) {
        LectureEvaluation lectureEvaluation = lectureEvaluationRepository.findById(lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureEvaluation;
    }
    @Override
    public List<LectureSchedule> getLectureSchedule(String lnum) {
        List<LectureSchedule> lectureSchedule = lectureScheduleRepository.findByLnum(lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureSchedule;
    }
    @Override
    public LectureAnnouncement getLectureAnnouncement(Long id, String lnum) {
        LectureAnnouncement lectureAnnouncement = lectureAnnouncementRepository.findByIdLnum(id, lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureAnnouncement;
    }
    @Override
    public List<LectureAnnouncement> getAllLectureAnnouncement(String lnum) {
        List<LectureAnnouncement> lectureAnnouncementList = lectureAnnouncementRepository.findAllByLnum(lnum);
        return lectureAnnouncementList;
    }
    @Override
    public LectureReference getLectureReference(Long id, String lnum) {
        LectureReference lectureReference = lectureReferenceRepository.findByIdLnum(id, lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureReference;
    }
    @Override
    public List<LectureReference> getAllLectureReference(String lnum) {
        List<LectureReference> lectureReferenceList = lectureReferenceRepository.findAllByLnum(lnum);
        return lectureReferenceList;
    }
    @Override
    public LectureAskAnswer getLectureAskAnswer(Long id, String lnum) {
        LectureAskAnswer lectureAskAnswer = lectureAskAnswerRepository.findByIdLnum(id, lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureAskAnswer;
    }
    @Override
    public List<LectureAskAnswer> getAllLectureAskAnswer(String lnum) {
        List<LectureAskAnswer> lectureAskAnswerList = lectureAskAnswerRepository.findAllByLnum(lnum);
        return lectureAskAnswerList;
    }
    @Override
    public LectureAskAnswerComment getLectureAskAnswerComment(Long comid, Long id, String lnum) {
        LectureAskAnswerComment lectureAskAnswerComment = lectureAskAnswerCommentRepository.findByComidIdLnum(comid, id, lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureAskAnswerComment;
    }
    @Override
    public List<LectureAskAnswerComment> getAllLectureAskAnswerComment(Long id, String lnum) {
        List<LectureAskAnswerComment> lectureAskAnswerCommentList = lectureAskAnswerCommentRepository.findAllByIdLnum(id, lnum);
        return lectureAskAnswerCommentList;
    }
    @Override
    public LectureAssignment getLectureAssignment(Long id, String lnum) {
        LectureAssignment lectureAssignment = lectureAssignmentRepository.findByIdLnum(id, lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureAssignment;
    }
    @Override
    public List<LectureAssignment> getAllLectureAssignment(String lnum) {
        List<LectureAssignment> lectureAssignmentList = lectureAssignmentRepository.findAllByLnum(lnum);
        return lectureAssignmentList;
    }
    @Override
    public void enrollLecture(LectureDTO lectureDTO) {
        if(lectureRepository.findByLnum(lectureDTO.getLnum()).isPresent())
            throw new IllegalArgumentException("ALREADY_EXISTS");
        Lecture lecture = Lecture.builder()
                .lnum(lectureDTO.getLnum())
                .name(lectureDTO.getName())
                .classfication(lectureDTO.getClassification())
                .lyear(lectureDTO.getLyear())
                .lsemester(lectureDTO.getLsemester())
                .lroom(lectureDTO.getLroom())
                .pid(lectureDTO.getPid())
                .pname(lectureDTO.getPname())
                .enroll(lectureDTO.getEnroll())
                .linfo(lectureDTO.getLinfo())
                .obj_method(lectureDTO.getObj_method())
                .build();
        lectureRepository.save(lecture);
    }
    @Override
    public void enrollStudent(LectureStudentDTO lectureStudentDTO) {
        if(lectureStudentRepository.findBySidLnum(lectureStudentDTO.getSid(), lectureStudentDTO.getLnum()).isPresent())
            throw new IllegalArgumentException("ALREADY_EXISTS");
        LectureStudent lectureStudent = LectureStudent.builder()
                .lnum(lectureStudentDTO.getLnum())
                .lyear(lectureStudentDTO.getLyear())
                .lsemester(lectureStudentDTO.getLsemester())
                .sid(lectureStudentDTO.getSid())
                .build();
        lectureStudentRepository.save(lectureStudent);
    }
    @Override
    public void enrollLectureTime(LectureTimeDTO lectureTimeDTO) {
        if(lectureTimeRepository.findById(lectureTimeDTO.getLnum()).isPresent())
            throw new IllegalArgumentException("ALREADY_EXISTS");
        LectureTime lectureTime = LectureTime.builder()
                .lnum(lectureTimeDTO.getLnum())
                .lt1_day(lectureTimeDTO.getLt1_day())
                .lt1_time(lectureTimeDTO.getLt1_time())
                .lt2_day(lectureTimeDTO.getLt2_day())
                .lt2_time(lectureTimeDTO.getLt2_time())
                .build();
        lectureTimeRepository.save(lectureTime);
    }
    @Override
    public void enrollLectureEvaluation(String lnum) {
        if(lectureEvaluationRepository.findById(lnum).isPresent())
            throw new IllegalArgumentException("ALREADY_EXISTS");
        LectureEvaluation lectureEvaluation = LectureEvaluation.builder()
                .lnum(lnum)
                .build();
        lectureEvaluationRepository.save(lectureEvaluation);
    }
    @Override
    public void enrollLectureSchedule(String lnum, Long week) {
        LectureScheduleID lectureScheduleID = new LectureScheduleID(lnum, week);
        if(lectureScheduleRepository.findById(lectureScheduleID).isPresent())
            throw new IllegalArgumentException("ALREADY_EXISTS");
        LectureSchedule lectureSchedule = LectureSchedule.builder()
                .lnum(lnum)
                .week(week)
                .build();
        lectureScheduleRepository.save(lectureSchedule);
    }
    @Override
    public void enrollLectureAnnouncement(LectureAnnouncementDTO lectureAnnouncementDTO) {
        LectureAnnouncement lectureAnnouncement = LectureAnnouncement.builder()
                .lnum(lectureAnnouncementDTO.getLnum())
                .title(lectureAnnouncementDTO.getTitle())
                .contents(lectureAnnouncementDTO.getContents())
                .writer(lectureAnnouncementDTO.getWriter())
                .build();
        lectureAnnouncementRepository.save(lectureAnnouncement);
    }
    @Override
    public void enrollLectureReference(LectureReferenceDTO lectureReferenceDTO) {
        LectureReference lectureReference = LectureReference.builder()
                .lnum(lectureReferenceDTO.getLnum())
                .title(lectureReferenceDTO.getTitle())
                .contents(lectureReferenceDTO.getContents())
                .writer(lectureReferenceDTO.getWriter())
                .build();
        lectureReferenceRepository.save(lectureReference);
    }
    @Override
    public void enrollLectureAskAnswer(LectureAskAnswerDTO lectureAskAnswerDTO) {
        LectureAskAnswer lectureAskAnswer = LectureAskAnswer.builder()
                .lnum(lectureAskAnswerDTO.getLnum())
                .title(lectureAskAnswerDTO.getTitle())
                .contents(lectureAskAnswerDTO.getContents())
                .writer(lectureAskAnswerDTO.getWriter())
                .build();
        lectureAskAnswerRepository.save(lectureAskAnswer);
    }
    @Override
    public void enrollLectureAskAnswerComment(LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO) {
        LectureAskAnswerComment lectureAskAnswerComment = LectureAskAnswerComment.builder()
                .lnum(lectureAskAnswerCommentDTO.getLnum())
                .id(lectureAskAnswerCommentDTO.getId())
                .contents(lectureAskAnswerCommentDTO.getContents())
                .writer(lectureAskAnswerCommentDTO.getWriter())
                .build();
        lectureAskAnswerCommentRepository.save(lectureAskAnswerComment);
    }
    @Override
    public void enrollLectureAssignment(LectureAssignmentDTO lectureAssignmentDTO) {
        LectureAssignment lectureAssignment = LectureAssignment.builder()
                .lnum(lectureAssignmentDTO.getLnum())
                .title(lectureAssignmentDTO.getTitle())
                .contents(lectureAssignmentDTO.getContents())
                .startdate(lectureAssignmentDTO.getStartdate())
                .duedate(lectureAssignmentDTO.getDuedate())
                .build();
        lectureAssignmentRepository.save(lectureAssignment);
    }
    @Override
    public void updateLecture(LectureDTO lectureDTO) {
        Lecture lecture = lectureRepository.findByLnum(lectureDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lecture.update(lectureDTO);
        lectureRepository.save(lecture);
    }
    @Override
    public void updateLectureTime(LectureTimeDTO lectureTimeDTO) {
        LectureTime lectureTime = lectureTimeRepository.findById(lectureTimeDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureTime.update(lectureTimeDTO);
        lectureTimeRepository.save(lectureTime);
    }
    @Override
    public void updateLectureEvaluation(LectureEvaluationDTO lectureEvaluationDTO) {
        LectureEvaluation lectureEvaluation = lectureEvaluationRepository.findById(lectureEvaluationDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureEvaluation.update(lectureEvaluationDTO);
        lectureEvaluationRepository.save(lectureEvaluation);
    }
    @Override
    public void updateLectureSchedule(LectureScheduleDTO lectureScheduleDTO) {
        LectureScheduleID lectureScheduleID = new LectureScheduleID(lectureScheduleDTO.getLnum(), lectureScheduleDTO.getWeek());
        LectureSchedule lectureSchedule = lectureScheduleRepository.findById(lectureScheduleID)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureSchedule.update(lectureScheduleDTO);
        lectureScheduleRepository.save(lectureSchedule);
    }
    @Override
    public void updateLectureAnnouncement(Long id, LectureAnnouncementDTO lectureAnnouncementDTO) {
        LectureAnnouncement lectureAnnouncement = lectureAnnouncementRepository.findByIdLnum(id, lectureAnnouncementDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureAnnouncement.update(lectureAnnouncementDTO);
        lectureAnnouncementRepository.save(lectureAnnouncement);
    }
    @Override
    public void updateLectureReference(Long id, LectureReferenceDTO lectureReferenceDTO) {
        LectureReference lectureReference = lectureReferenceRepository.findByIdLnum(id, lectureReferenceDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureReference.update(lectureReferenceDTO);
        lectureReferenceRepository.save(lectureReference);
    }
    @Override
    public void updateLectureAskAnswer(Long id, LectureAskAnswerDTO lectureAskAnswerDTO) {
        LectureAskAnswer lectureAskAnswer = lectureAskAnswerRepository.findByIdLnum(id, lectureAskAnswerDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureAskAnswer.update(lectureAskAnswerDTO);
        lectureAskAnswerRepository.save(lectureAskAnswer);
    }
    @Override
    public void updateLectureAskAnswerComment(Long comid, LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO) {
        LectureAskAnswerComment lectureAskAnswerComment = lectureAskAnswerCommentRepository.findByComidIdLnum(comid, lectureAskAnswerCommentDTO.getId(), lectureAskAnswerCommentDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureAskAnswerComment.update(lectureAskAnswerCommentDTO);
        lectureAskAnswerCommentRepository.save(lectureAskAnswerComment);
    }
    @Override
    public void updateLectureAssignment(Long id, LectureAssignmentDTO lectureAssignmentDTO) {
        LectureAssignment lectureAssignment = lectureAssignmentRepository.findByIdLnum(id, lectureAssignmentDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureAssignment.update(lectureAssignmentDTO);
        lectureAssignmentRepository.save(lectureAssignment);
    }
    @Override
    public void deleteLecture(String lnum) {
        lectureRepository.deleteById(lnum);
        /*
        lectureTimeRepository.deleteById(lnum);
        lectureEvaluationRepository.deleteById(lnum);
        lectureAnnouncementRepository.deleteByLnum(lnum);
        lectureReferenceRepository.deleteByLnum(lnum);
        lectureAskAnswerRepository.deleteByLnum(lnum);
        lectureAssignmentRepository.deleteByLnum(lnum);
        */
    }
    @Override
    public void deleteStudent(String sid, String lnum) {
        LectureStudentID lectureStudentID = new LectureStudentID(sid, lnum);
        lectureStudentRepository.deleteById (lectureStudentID);
    }
    @Override
    public void deleteLectureAnnouncement(Long id, String lnum) {
        LectureAnnouncement lectureAnnouncement = lectureAnnouncementRepository.findByIdLnum(id, lnum)
                        .orElseThrow(() -> new IllegalArgumentException("NO DATA"));
        lectureAnnouncementRepository.delete(lectureAnnouncement);
    }
    @Override
    public void deleteLectureReference(Long id, String lnum) {
        LectureReference lectureReference = lectureReferenceRepository.findByIdLnum(id, lnum)
                        .orElseThrow(() -> new IllegalArgumentException("NO DATA"));
        lectureReferenceRepository.delete(lectureReference);
    }
    @Override
    public void deleteLectureAskAnswer(Long id, String lnum) {
        LectureAskAnswer lectureAskAnswer = lectureAskAnswerRepository.findByIdLnum(id, lnum)
                        .orElseThrow(() -> new IllegalArgumentException("NO DATA"));
        lectureAskAnswerRepository.delete(lectureAskAnswer);
    }
    @Override
    public void deleteLectureAskAnswerComment(Long comid, Long id, String lnum) {
        LectureAskAnswerComment lectureAskAnswerComment = lectureAskAnswerCommentRepository.findByComidIdLnum(comid, id, lnum)
                        .orElseThrow(() -> new IllegalArgumentException("NO DATA"));
        lectureAskAnswerCommentRepository.delete(lectureAskAnswerComment);
    }
    @Override
    public void deleteLectureAssignment(Long id, String lnum) {
        LectureAssignment lectureAssignment = lectureAssignmentRepository.findByIdLnum(id, lnum)
                        .orElseThrow(() -> new IllegalArgumentException("NO DATA"));
        lectureAssignmentRepository.delete(lectureAssignment);
    }
}
