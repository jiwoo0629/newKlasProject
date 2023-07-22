package jiwoo.newKlasProject.Controller;

import jiwoo.newKlasProject.DTO.Lecture.*;
import jiwoo.newKlasProject.Entity.Lecture.*;
import jiwoo.newKlasProject.Service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureController {
    private final LectureService lectureService;

    @GetMapping("/get")
    public ResponseEntity<Lecture> getLecture (@RequestParam("lnum") String lnum, @RequestParam("name") String name) {
        Lecture lecture = lectureService.getLecture(lnum, name);
        return ResponseEntity.ok().body(lecture);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Lecture>> getAllLecture() {
        List<Lecture> lectureList = lectureService.getAllLecture();
        return ResponseEntity.ok().body(lectureList);
    }
    @GetMapping("/getStudentByLnum")
    public ResponseEntity<List<LectureStudent>> getStudentByLnum(@RequestParam("lnum") String lnum) {
        List<LectureStudent> studentList = lectureService.getStudentByLnum(lnum);
        return ResponseEntity.ok().body(studentList);
    }
    @GetMapping("/getLectureBySid")
    public ResponseEntity<List<LectureStudent>> getLectureBySid(@RequestParam("sid") String sid) {
        List<LectureStudent> lectureList = lectureService.getLectureBySid(sid);
        return ResponseEntity.ok().body(lectureList);
    }
    @GetMapping("/getTime")
    public ResponseEntity<LectureTime> getLectureTime (@RequestParam("lnum") String lnum) {
        LectureTime lectureTime = lectureService.getLectureTime(lnum);
        return ResponseEntity.ok().body(lectureTime);
    }
    @GetMapping("/getEvaluation")
    public ResponseEntity<LectureEvaluation> getLectureEvaluation (@RequestParam("lnum") String lnum) {
        LectureEvaluation lectureEvaluation = lectureService.getLectureEvaluation(lnum);
        return ResponseEntity.ok().body(lectureEvaluation);
    }
    @GetMapping("/getSchedule")
    public ResponseEntity<List<LectureSchedule>> getLectureSchedule (@RequestParam("lnum") String lnum) {
        List<LectureSchedule> lectureSchedule = lectureService.getLectureSchedule(lnum);
        return ResponseEntity.ok().body(lectureSchedule);
    }
    @GetMapping("/getAnnouncement")
    public ResponseEntity<LectureAnnouncement> getLectureAnnouncement (@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        LectureAnnouncement lectureAnnouncement = lectureService.getLectureAnnouncement(id, lnum);
        return ResponseEntity.ok().body(lectureAnnouncement);
    }
    @GetMapping("/getAllAnnouncement")
    public ResponseEntity<List<LectureAnnouncement>> getAllLectureAnnouncement (@RequestParam("lnum") String lnum) {
        List<LectureAnnouncement> lectureAnnouncementList = lectureService.getAllLectureAnnouncement(lnum);
        return ResponseEntity.ok().body(lectureAnnouncementList);
    }
    @GetMapping("/getReference")
    public ResponseEntity<LectureReference> getLectureReference (@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        LectureReference lectureReference = lectureService.getLectureReference(id, lnum);
        return ResponseEntity.ok().body(lectureReference);
    }
    @GetMapping("/getAllReference")
    public ResponseEntity<List<LectureReference>> getAllLectureReference (@RequestParam("lnum") String lnum) {
        List<LectureReference> lectureReferenceList = lectureService.getAllLectureReference(lnum);
        return ResponseEntity.ok().body(lectureReferenceList);
    }
    @GetMapping("/getAskAnswer")
    public ResponseEntity<LectureAskAnswer> getLectureAskAnswer (@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        LectureAskAnswer lectureAskAnswer = lectureService.getLectureAskAnswer(id, lnum);
        return ResponseEntity.ok().body(lectureAskAnswer);
    }
    @GetMapping("/getAllAskAnswer")
    public ResponseEntity<List<LectureAskAnswer>> getAllLectureAskAnswer (@RequestParam("lnum") String lnum) {
        List<LectureAskAnswer> lectureAskAnswerList = lectureService.getAllLectureAskAnswer(lnum);
        return ResponseEntity.ok().body(lectureAskAnswerList);
    }
    @GetMapping("/getAskAnswerComment")
    public ResponseEntity<LectureAskAnswerComment> getLectureAskAnswerComment (@RequestParam("comid") Long comid, @RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        LectureAskAnswerComment lectureAskAnswerComment = lectureService.getLectureAskAnswerComment(comid, id, lnum);
        return ResponseEntity.ok().body(lectureAskAnswerComment);
    }
    @GetMapping("/getAllAskAnswerComment")
    public ResponseEntity<List<LectureAskAnswerComment>> getAllLectureAskAnswerComment (@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        List<LectureAskAnswerComment> lectureAskAnswerCommentList = lectureService.getAllLectureAskAnswerComment(id, lnum);
        return ResponseEntity.ok().body(lectureAskAnswerCommentList);
    }
    @GetMapping("/getAssignment")
    public ResponseEntity<LectureAssignment> getLectureAssignment (@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        LectureAssignment lectureAssignment = lectureService.getLectureAssignment(id, lnum);
        return ResponseEntity.ok().body(lectureAssignment);
    }
    @GetMapping("/getAllAssignment")
    public ResponseEntity<List<LectureAssignment>> getAllLectureAssignment (@RequestParam("lnum") String lnum) {
        List<LectureAssignment> lectureAssignmentList = lectureService.getAllLectureAssignment(lnum);
        return ResponseEntity.ok().body(lectureAssignmentList);
    }
    @PostMapping("/enroll")
    public ResponseEntity<HttpStatus> enrollLecture(@RequestBody LectureDTO lectureDTO) {
        lectureService.enrollLecture(lectureDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollStudent")
    public ResponseEntity<HttpStatus> enrollStudent(@RequestBody LectureStudentDTO lectureStudentDTO) {
        lectureService.enrollStudent(lectureStudentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollTime")
    public ResponseEntity<HttpStatus> enrollLectureTime(@RequestBody LectureTimeDTO lectureTimeDTO) {
        lectureService.enrollLectureTime(lectureTimeDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollEvaluation")
    public ResponseEntity<HttpStatus> enrollLectureEvaluation(@RequestParam String lnum) {
        lectureService.enrollLectureEvaluation(lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollSchedule")
    public ResponseEntity<HttpStatus> enrollLectureSchedule(@RequestParam String lnum) {
        for(int i=1; i<16; i++)
            lectureService.enrollLectureSchedule(lnum, Long.valueOf(i));
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollAnnouncement")
    public ResponseEntity<HttpStatus> enrollLectureAnnouncement(@RequestBody LectureAnnouncementDTO lectureAnnouncementDTO) {
        lectureService.enrollLectureAnnouncement(lectureAnnouncementDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollReference")
    public ResponseEntity<HttpStatus> enrollLectureReference(@RequestBody LectureReferenceDTO lectureReferenceDTO) {
        lectureService.enrollLectureReference(lectureReferenceDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollAskAnswer")
    public ResponseEntity<HttpStatus> enrollLectureAskAnswer(@RequestBody LectureAskAnswerDTO lectureAskAnswerDTO) {
        lectureService.enrollLectureAskAnswer(lectureAskAnswerDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollAskAnswerComment")
    public ResponseEntity<HttpStatus> enrollLectureAskAnswerComment(@RequestBody LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO) {
        lectureService.enrollLectureAskAnswerComment(lectureAskAnswerCommentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollAssignment")
    public ResponseEntity<HttpStatus> enrollLectureAssignment(@RequestBody LectureAssignmentDTO lectureAssignmentDTO) {
        lectureService.enrollLectureAssignment(lectureAssignmentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/update")
    public ResponseEntity<HttpStatus> updateLecture(@RequestBody LectureDTO lectureDTO) {
        lectureService.updateLecture(lectureDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateTime")
    public ResponseEntity<HttpStatus> updateLectureTime(@RequestBody LectureTimeDTO lectureTimeDTO) {
        lectureService.updateLectureTime(lectureTimeDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateEvaluation")
    public ResponseEntity<HttpStatus> updateLectureEvaluation(@RequestBody LectureEvaluationDTO lectureEvaluationDTO) {
        lectureService.updateLectureEvaluation(lectureEvaluationDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateSchedule")
    public ResponseEntity<HttpStatus> updateLectureSchedule(@RequestBody LectureScheduleDTO[] params) {
        for(int i=0; i<15; i++) {
            LectureScheduleDTO lectureScheduleDTO = params[i];
            lectureService.updateLectureSchedule(lectureScheduleDTO);
        }
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateAnnouncement")
    public ResponseEntity<HttpStatus> updateLectureAnnouncement(@RequestParam("id") Long id, @RequestBody LectureAnnouncementDTO lectureAnnouncementDTO) {
        lectureService.updateLectureAnnouncement(id, lectureAnnouncementDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateReference")
    public ResponseEntity<HttpStatus> updateLectureReference(@RequestParam("id") Long id, @RequestBody LectureReferenceDTO lectureReferenceDTO) {
        lectureService.updateLectureReference(id, lectureReferenceDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateAskAnswer")
    public ResponseEntity<HttpStatus> updateLectureAskAnswer(@RequestParam("id") Long id, @RequestBody LectureAskAnswerDTO lectureAskAnswerDTO) {
        lectureService.updateLectureAskAnswer(id, lectureAskAnswerDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateAskAnswerComment")
    public ResponseEntity<HttpStatus> updateLectureAskAnswerComment(@RequestParam("comid") Long comid, @RequestBody LectureAskAnswerCommentDTO lectureAskAnswerCommentDTO) {
        lectureService.updateLectureAskAnswerComment(comid, lectureAskAnswerCommentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/updateAssignment")
    public ResponseEntity<HttpStatus> updateLectureAssignment(@RequestParam("id") Long id, @RequestBody LectureAssignmentDTO lectureAssignmentDTO) {
        lectureService.updateLectureAssignment(id, lectureAssignmentDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteLecture(@RequestParam("lnum") String lnum) {
        lectureService.deleteLecture(lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/deleteStudent")
    public ResponseEntity<HttpStatus> deleteStudent(@RequestParam("sid") String sid, @RequestParam("lnum") String lnum) {
        lectureService.deleteStudent(sid, lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/deleteAnnouncement")
    public ResponseEntity<HttpStatus> deleteLectureAnnouncement(@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        lectureService.deleteLectureAnnouncement(id, lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/deleteReference")
    public ResponseEntity<HttpStatus> deleteLectureReference(@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        lectureService.deleteLectureReference(id, lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/deleteAskAnswer")
    public ResponseEntity<HttpStatus> deleteLectureAskAnswer(@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        lectureService.deleteLectureAskAnswer(id, lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/deleteAskAnswerComment")
    public ResponseEntity<HttpStatus> deleteLectureAskAnswerComment(@RequestParam("comid") Long comid, @RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        lectureService.deleteLectureAskAnswerComment(comid, id, lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @DeleteMapping("/deleteAssignment")
    public ResponseEntity<HttpStatus> deleteLectureAssignment(@RequestParam("id") Long id, @RequestParam("lnum") String lnum) {
        lectureService.deleteLectureAssignment(id, lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
