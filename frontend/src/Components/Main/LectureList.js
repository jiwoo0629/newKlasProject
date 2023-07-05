import React from 'react';
import styled from 'styled-components';
import EachLecture from './EachLecture';

const LectureContainer = styled.div`
    position:absolute; left:15%; top:700px;
    width:66%; padding:2%;
    display:flex;
    border:1.5px solid lightgray; border-radius:5px;
    background:white; z-index:-1;
    margin-bottom:100px;
`
const LectureLayer = styled.div`
    position:absolute;
    width:95%; height:40px;
    font-size:24px; color:black;
    border-bottom:1px solid gray;
`
const ListContainer = styled.div`
    position:relative; top:40px;
`

export default function LectureList (props) {
    const lectureList = props.Lecture.map((data) => (
        <EachLecture data={data} />
    ));
    return (
        <>
            <LectureLayer><b>수강과목</b> ({props.semester})</LectureLayer>
            <ListContainer>
                {lectureList}<p />
            </ListContainer>
        </>
    );
}