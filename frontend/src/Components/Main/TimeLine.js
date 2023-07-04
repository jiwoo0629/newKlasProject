import React from 'react';
import styled from 'styled-components';

const Timeline = styled.table`
    position:absolute; top:100px;
    width: 95%; height:400px;
    border: 1px solid gray; border-bottom:0px; border-collapse: collapse;
    text-align:center;
`
const DayTr = styled.tr`
    height:40px; font-size:20px; font-weight:600;
    border-bottom:1px solid gray;
`
const DayTd = styled.td`
    height:40px; text-align:center;
    border-right:1px solid gray;
    color:${props => props.day === week[new Date().getDay()] ? "white" : "black"};
    background-color:${props => props.day === week[new Date().getDay()] ? "rgb(238, 196, 118)" : "white"};
`
const LectureTr = styled.tr`
    height:60px; font-size:15px;
    border-bottom:1px solid gray;
`
const LectureTd = styled.td`
    height:60px; text-align:center;
    border-right:1px solid gray;
`

const week = ['일','월','화','수','목','금','토'];

export default function TimeLine (props) {
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
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd style={{border:"0px"}}></LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>2</td>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd style={{border:"0px"}}></LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>3</td>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd style={{border:"0px"}}></LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>4</td>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd style={{border:"0px"}}></LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>5</td>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd style={{border:"0px"}}></LectureTd>
            </LectureTr>
            <LectureTr>
                <td style={{width:"5%", borderRight:"1px solid gray"}}>6</td>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd></LectureTd>
                <LectureTd style={{border:"0px"}}></LectureTd>
            </LectureTr>
        </Timeline>
    );
}