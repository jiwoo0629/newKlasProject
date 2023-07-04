import React, {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';
import dayjs from 'dayjs';
import UpperLayer from '../Components/Main/UpperLayer';
import TimeLine from '../Components/Main/TimeLine';
import LectureList from '../Components/Main/LectureList';
import NoticeList from '../Components/Main/NoticeList';

const Container = styled.div`
    width: 100%;
    background: rgba(153, 153, 153, 0.05); z-index:-2;
    padding-bottom:100px;
`
const Schedule_Container = styled.div`
    position:relative; left:15%; top:100px;
    width:66%; height:480px; padding:2%;
    display:flex; justify-content:center;
    border:1.5px solid lightgray; border-radius:5px;
    margin-bottom:50px;
    background:white;
`
const Semester = styled.select`
    position:absolute; top:30px;
    width:200px; height:30px;
    border:1px solid black; border-radius:3px;
    padding-left:5px; font-size:18px;
`
const Today = styled.div`
    position:absolute; top:65px;
    width:200px;
    display:flex; justify-content:center;
    color:gray; font-size:15px;
`
const LectureContainer = styled.div`
    position:relative; left:15%; top:100px;
    width:66%; padding:2%;
    display:flex;
    border:1.5px solid lightgray; border-radius:5px;
    background:white;
    margin-bottom: 50px;
`

const week = ['일','월','화','수','목','금','토'];

const Lecture = [
    { lnum: "0000-2-8834-01", name: "법과권리", pname: "한재경", lroom: "한울관 B102호", lt1_day: "월", lt1_time: 3, lt2_day: "수", lt2_time: 4},
    { lnum: "H020-4-8995-01", name: "산학협력캡스톤설계1", pname: "이형근", lroom: "새빛관 102호", lt1_day: "화", lt1_time: 6, lt2_day: "목", lt2_time: 5},
    { lnum: "0000-2-9251-01", name: "신기술과미래사회", pname: "김충혁", lroom: "한울관 203호", lt1_day: "월", lt1_time: 4, lt2_day: "수", lt2_time: 3},
];

const Notice = [
    { name: "산학협력캡스톤설계1", title: "최종성적 확인", type: "강의 공지사항", date: "2023-06-26"},
    { name: "법과권리", title: "법과 권리 세부성적 공지", type: "강의 공지사항", date: "2023-06-26"},
    { name: "법과권리", title: "[법과권리] 설문조사 협조 요청", type: "강의 공지사항", date: "2023-06-20"},
    { name: "산학협력캡스톤설계1", title: "최종결과보고서 제출 및 평가 방안", type: "강의 공지사항", date: "2023-06-13"},
    { name: "산학협력캡스톤설계1", title: "TOPCIT 응시 결과", type: "과제", date: "2023-06-13"}
]

export default function MainPage () {
    const [semester, setSemester] = useState("2023학년도 1학기");
    const onSelect = (e) => {
        setSemester(e.target.value);
    }
    return (
        <Container>
            <UpperLayer />
            <Schedule_Container>
                <Semester value={semester} onChange={onSelect}>
                    <option value="2022학년도 2학기" key="2022_2">2022학년도 2학기</option>
                    <option value="2023학년도 1학기" key="2023_1">2023학년도 1학기</option>
                </Semester>
                <Today>({dayjs(new Date()).format("YYYY년 MM월 DD일 ")}{week[new Date().getDay()]}요일)</Today>
                <TimeLine Lecture={Lecture} />
            </Schedule_Container>
            <LectureContainer>
                <LectureList Lecture={Lecture} semester={semester} />
            </LectureContainer>
            <LectureContainer>
                <NoticeList Notice={Notice} />
            </LectureContainer>
        </Container>

    );
}