import React, {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';
import dayjs from 'dayjs';
import UpperLayer from '../Components/Main/UpperLayer';
import TimeLine from '../Components/Main/TimeLine';
import LectureList from '../Components/Main/LectureList';

const Container = styled.div`
    position:absolute;
    width:100%; height:2000px;
    background: rgba(153, 153, 153, 0.05); z-index:-2;
`
const Schedule_Container = styled.div`
    position:absolute; left:15%; top:100px;
    width:66%; height:480px; padding:2%;
    display:flex; justify-content:center;
    border:1.5px solid lightgray; border-radius:5px;
    background:white; z-index:-1;
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

const week = ['일','월','화','수','목','금','토'];

const Lecture = [
    { lnum: "0000-2-8834-01", name: "법과권리", pname: "한재경", lroom: "한울관 B102호", ltime: "월 3교시, 수 4교시"},
    { lnum: "H020-4-8995-01", name: "산학협력캡스톤설계1", pname: "이형근", lroom: "새빛관 102호", ltime: "화 6교시, 목 5교시"},
    { lnum: "0000-2-9251-01", name: "신기술과미래사회", pname: "김충혁", lroom: "한울관 203호", ltime: "월 4교시, 수 3교시"},
];

export default function MainPage () {
    const [semester, setSemester] = useState("2023학년도 1학기");
    const onSelect = (e) => {
        setSemester(e.target.value);
    }
    return (
        <Container>
            <UpperLayer />
            <Schedule_Container>
                <Today>({dayjs(new Date()).format("YYYY년 MM월 DD일 ")}{week[new Date().getDay()]}요일)</Today>
                <Semester value={semester} onChange={onSelect}>
                    <option value="2023학년도 1학기">2023학년도 1학기</option>
                </Semester>
                <TimeLine />
            </Schedule_Container>
            <LectureList Lecture={Lecture} semester={semester} />
        </Container>
    );
}