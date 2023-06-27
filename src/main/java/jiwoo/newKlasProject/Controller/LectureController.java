package jiwoo.newKlasProject.Controller;

import jiwoo.newKlasProject.DTO.Lecture.LectureDTO;
import jiwoo.newKlasProject.DTO.Lecture.LectureTimeDTO;
import jiwoo.newKlasProject.Entity.Lecture.Lecture;
import jiwoo.newKlasProject.Entity.Lecture.LectureTime;
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
    @GetMapping("/getTime")
    public ResponseEntity<LectureTime> getLectureTime (@RequestParam("lnum") String lnum) {
        LectureTime lectureTime = lectureService.getLectureTime(lnum);
        return ResponseEntity.ok().body(lectureTime);
    }
    @PostMapping("/enroll")
    public ResponseEntity<HttpStatus> enrollLecture(@RequestBody LectureDTO lectureDTO) {
        lectureService.enrollLecture(lectureDTO);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
    @PostMapping("/enrollTime")
    public ResponseEntity<HttpStatus> enrollLectureTime(@RequestBody LectureTimeDTO lectureTimeDTO) {
        lectureService.enrollLectureTime(lectureTimeDTO);
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
    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteLecture(@RequestParam("lnum") String lnum) {
        lectureService.deleteLecture(lnum);
        return ResponseEntity.ok().body(HttpStatus.OK);
    }
}
