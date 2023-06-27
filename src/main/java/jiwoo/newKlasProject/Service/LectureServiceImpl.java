package jiwoo.newKlasProject.Service;

import jiwoo.newKlasProject.DTO.Lecture.LectureDTO;
import jiwoo.newKlasProject.DTO.Lecture.LectureTimeDTO;
import jiwoo.newKlasProject.Entity.Lecture.Lecture;
import jiwoo.newKlasProject.Entity.Lecture.LectureTime;
import jiwoo.newKlasProject.Repository.Lecture.LectureRepository;
import jiwoo.newKlasProject.Repository.Lecture.LectureTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LectureServiceImpl implements LectureService{
    private final LectureRepository lectureRepository;
    private final LectureTimeRepository lectureTimeRepository;
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
    public LectureTime getLectureTime(String lnum) {
        LectureTime lectureTime = lectureTimeRepository.findByLnum(lnum)
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        return lectureTime;
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
    public void enrollLectureTime(LectureTimeDTO lectureTimeDTO) {
        if(lectureRepository.findByLnum(lectureTimeDTO.getLnum()).isPresent())
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
    public void updateLecture(LectureDTO lectureDTO) {
        Lecture lecture = lectureRepository.findByLnum(lectureDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lecture.update(lectureDTO);
        lectureRepository.save(lecture);
    }
    @Override
    public void updateLectureTime(LectureTimeDTO lectureTimeDTO) {
        LectureTime lectureTime = lectureTimeRepository.findByLnum(lectureTimeDTO.getLnum())
                .orElseThrow(() -> new IllegalArgumentException("NO_DATA"));
        lectureTime.update(lectureTimeDTO);
        lectureTimeRepository.save(lectureTime);
    }
    @Override
    public void deleteLecture(String lnum) {
        lectureRepository.deleteById(lnum);
        lectureTimeRepository.deleteById(lnum);
    }
}
