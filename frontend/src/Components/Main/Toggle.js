import React from 'react';
import styled from 'styled-components';
import axios from 'axios';

const Container = styled.div`
    position:absolute; left:20%; top:70px;
    width:60%; height:300px;
    border:0px; border-top:0px; border-radius:5px; box-shadow: 2px 3px 5px 0px gray;
    background: white;
`
const CampusLife = styled.div`
    position:absolute; left:3%; top:20px;
    width:45%; height:250px;
    color:black;
`
const LectureInfo = styled.div`
    position:absolute; left:52%; top:20px;
    width:45%; height:250px;
    color:black;
`
const Title = styled.div`
    width:100%; height:40px;
    display:flex; justify-content:center; align-items:center;
    font-size:24px; font-weight:600;
    border-bottom:1px solid black;
`
const SignUp = styled.div`
    position:absolute; left:3%; top:50px;
    width:45%; height:200px;
    color:black;
`
const LearningResult = styled.div`
    position:absolute; left:52%; top:50px;
    width:45%; height:200px;
    color:black;
`
const LearningSupport = styled.div`
    position:absolute; left:3%; top:50px;
    width:94%; height:200px;
    color:black;
`
const Div1 = styled.div`
    position:absolute; top:35px;
    width:50%; height:100px;
`
const Div2 = styled.div`
    position:absolute; top:35px; left:50%;
    width:50%; height:100px;
`

export default function Toggle () {
    return(
        <>
            <Container>
                <CampusLife>
                    <Title>대학생활</Title>
                    <SignUp>
                        <b>수강관리</b><br /><br />
                        - 수업시간표 <br /><p />
                        - 출석관리(KW출첵) <br /><p />
                        - 강의계획서 조회 <br /><p />
                        - 수강신청 프로그램
                    </SignUp>
                    <LearningResult>
                        <b>학습결과</b><br /><br />
                        - 수강/성적 조회 <br /><p />
                        - 석차 조회
                    </LearningResult>
                </CampusLife>
                <LectureInfo>
                    <Title>강의종합정보</Title>
                    <LearningSupport>
                        <b>학습지원실</b><br /><br />
                        <Div1>
                        - 강의종합 <br /><p />
                        - 강의 묻고답하기 <br /><p />
                        - 과제 제출 <br /><p />
                        </Div1>
                        <Div2>
                        - 강의 공지사항 <br /><p />
                        - 강의 자료실
                        </Div2>
                    </LearningSupport>
                </LectureInfo>
            </Container>
        </>
    );
}