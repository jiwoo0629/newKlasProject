import React from 'react';
import styled from 'styled-components';

const Timeline = styled.table`
    position:absolute; top:100px;
    width: 95%; height:400px;
    border: 1px solid gray; border-bottom:0px; border-collapse: collapse;
    text-align:center;
`
const DayTr = styled.tr`
    height:30px; font-size:18px; font-weight:600;
    border-bottom:1px solid gray;
`
const DayTd = styled.td`
    height:30px; text-align:center;
    border-right:1px solid gray;
    color:${props => props.day === week[new Date().getDay()] ? "white" : "black"};
    background-color:${props => props.day === week[new Date().getDay()] ? "rgb(238, 196, 118)" : "white"};
`
const LectureTr = styled.tr`
    height:60px; font-size:15px;
    border-bottom:1px solid gray;
`
const LectureTd = styled.td`
    height:60px; width: 180px;
    text-align:center;
    border-right:1px solid gray;
`
const EachTime = styled.div`
    height:54px; width:97%;
    font-size:14px; color:black;
    text-align:left;
    padding:3px;
`

const week = ['일','월','화','수','목','금','토'];
const color = ['#a29bfe', '#1abc9c', '#f1c40f', '#fab1a0', '#00cec9', '#9b59b6'];

export default function TimeLine (props) {
    const eachLecture = (day, time) => {
        for(var i=0; i<props.Lecture.length; i++) {
            const data = props.Lecture[i];
            if((day === data.lt1_day && time === data.lt1_time) || (day === data.lt2_day && time === data.lt2_time)) {
                return (
                    <EachTime style={{background: color[i]}}>
                        {data.name}({data.lroom}/{data.pname})
                    </EachTime>
                );
            }
        }
    }

    return (
        <Timeline>
            <DayTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}></td>
                <DayTd day="월">월</DayTd>
                <DayTd day="화">화</DayTd>
                <DayTd day="수">수</DayTd>
                <DayTd day="목">목</DayTd>
                <DayTd day="금" style={{border:"0px"}}>금</DayTd>
            </DayTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>1</td>
                <LectureTd>{eachLecture("월", 1)}</LectureTd>
                <LectureTd>{eachLecture("화", 1)}</LectureTd>
                <LectureTd>{eachLecture("수", 1)}</LectureTd>
                <LectureTd>{eachLecture("목", 1)}</LectureTd>
                <LectureTd friday style={{border:"0px"}}>{eachLecture("금", 1)}</LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>2</td>
                <LectureTd>{eachLecture("월", 2)}</LectureTd>
                <LectureTd>{eachLecture("화", 2)}</LectureTd>
                <LectureTd>{eachLecture("수", 2)}</LectureTd>
                <LectureTd>{eachLecture("목", 2)}</LectureTd>
                <LectureTd friday style={{border:"0px"}}>{eachLecture("금", 2)}</LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>3</td>
                <LectureTd>{eachLecture("월", 3)}</LectureTd>
                <LectureTd>{eachLecture("화", 3)}</LectureTd>
                <LectureTd>{eachLecture("수", 3)}</LectureTd>
                <LectureTd>{eachLecture("목", 3)}</LectureTd>
                <LectureTd friday style={{border:"0px"}}>{eachLecture("금", 3)}</LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>4</td>
                <LectureTd>{eachLecture("월", 4)}</LectureTd>
                <LectureTd>{eachLecture("화", 4)}</LectureTd>
                <LectureTd>{eachLecture("수", 4)}</LectureTd>
                <LectureTd>{eachLecture("목", 4)}</LectureTd>
                <LectureTd friday style={{border:"0px"}}>{eachLecture("금", 4)}</LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>5</td>
                <LectureTd>{eachLecture("월", 5)}</LectureTd>
                <LectureTd>{eachLecture("화", 5)}</LectureTd>
                <LectureTd>{eachLecture("수", 5)}</LectureTd>
                <LectureTd>{eachLecture("목", 5)}</LectureTd>
                <LectureTd friday style={{border:"0px"}}>{eachLecture("금", 5)}</LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>6</td>
                <LectureTd>{eachLecture("월", 6)}</LectureTd>
                <LectureTd>{eachLecture("화", 6)}</LectureTd>
                <LectureTd>{eachLecture("수", 6)}</LectureTd>
                <LectureTd>{eachLecture("목", 6)}</LectureTd>
                <LectureTd friday style={{border:"0px"}}>{eachLecture("금", 6)}</LectureTd>
            </LectureTr>
        </Timeline>
    );
}