import React from 'react';
import styled from 'styled-components';

const Lecture = styled.div`
    position:relative;
    width:1120px; height:50px;
    padding:10px 0px;
    font-size:20px;
    border-bottom:1px solid gray;
`
const Announcement = styled.button`
    position:absolute; left:740px; top:20px;
    width:120px; height:30px;
    font-size:15px; color:white;
    display:flex; justify-content: center; align-items:center;
    border:0px; border-radius:5px;
    background: orange;
`
const Reference = styled.button`
    position:absolute; left:870px; top:20px;
    width:120px; height:30px;
    font-size:15px; color:white;
    display:flex; justify-content: center; align-items:center;
    border:0px; border-radius:5px;
    background: lightgreen;
`
const AskAnswer = styled.button`
    position:absolute; left:1000px; top:20px;
    width:120px; height:30px;
    font-size:15px; color:white;
    display:flex; justify-content: center; align-items:center;
    border:0px; border-radius:5px;
    background: skyblue;
`

export default function EachLecture (props) {
    return (
        <Lecture>
            <p style={{fontSize:"20px", display:"inline"}}><b>{props.name}</b>({props.lnum})</p>
            <p style={{fontSize:"15px", color:"gray"}}>{props.pname} / {props.ltime} / {props.lroom}</p>
            <Announcement>공지사항</Announcement>
            <Reference>강의자료실</Reference>
            <AskAnswer>강의Q&A</AskAnswer>
        </Lecture>
    );
}