import React, {useState} from 'react';
import styled from 'styled-components';
import AddSInfo from '../Components/AddSInfo';
import AddPInfo from '../Components/AddPInfo';
import AddLInfo from '../Components/AddLInfo';

const Button1 = styled.button`
    position: absolute; left:25%; top: 100px;
    width:50%; height:150px;
    display: flex; justify-content: center; align-items:center; text-align:center;
    border: 3px solid black; border-radius: 10px;
    color:black; font-size:70px; font-weight:600;
`
const Button2 = styled.button`
    position: absolute; left:25%; top:350px;
    width:50%; height:150px;
    display: flex; justify-content: center; align-items:center; text-align:center;
    border: 3px solid black; border-radius: 10px;
    color:black; font-size:70px; font-weight:600;
`
const Button3 = styled.button`
    position: absolute; left:25%; top: 600px;
    width:50%; height:150px;
    display: flex; justify-content: center; align-items:center; text-align:center;
    border: 3px solid black; border-radius: 10px;
    color:black; font-size:70px; font-weight:600;
`

const TitleContainer = styled.div`
    position: absolute; width: 700px; height: 80px; left:30%; top: 70px;
    display:flex; justify-content: center; align-items: center;
    border-bottom: 1px solid black;
    font-weight: 500; font-size: 50px;
`

const GoBack = styled.button`
    position: absolute; left:600px;
    top: ${props => props.lecture ? '1150px' : '750px'};
    width:100px; height:50px;
    font-size:20px; font-weight:600; color:gray;
    border-radius:10px; border:2px solid gray;
`

const GoMain = styled.button`
    position: absolute; left:1000px;
    top: ${props => props.lecture ? '1150px' : '750px'};
    width:100px; height:50px;
    font-size:20px; font-weight:600; color:gray;
    border-radius:10px; border:2px solid gray;
`
//뒤로가기 관리 목적
var stack = ["main"];
var top = 0;

export default function AdminPage() {
    const [type, setType] = useState("main");
    const onChangePage = (e) => {
        stack.push(e.target.value);
        top++;
        setType(stack[top]);
    }
    const goBack = () => {
        stack.pop();
        top--;
        setType(stack[top]);
    }
    const goMain = () => {
        while(top > 0) {
            stack.pop();
            top--;
        }
        setType(stack[top])
    }
    const diffPage = (type) => {
        if(type === "main") {
            return (
                <div>
                    <Button1 value="student" onClick={onChangePage}>학생정보 관리</Button1>
                    <Button2 value="professor" onClick={onChangePage}>교수정보 관리</Button2>
                    <Button3 value="lecture" onClick={onChangePage}>강의정보 관리</Button3>
                </div>
            );
        }
        else if(type === "student") {
            return (
                <div>
                    <Button1 value="addStudentInfo" onClick={onChangePage}>학생정보 추가</Button1>
                    <Button2 value="ChangeStudentInfo" onClick={onChangePage}>학생정보 조회 및 변경</Button2>
                    <GoBack onClick = {goBack}>뒤로가기</GoBack>
                    <GoMain onClick = {goMain}>메인으로</GoMain>
                </div>
            );
        }
        else if(type === "professor") {
            return (
                <div>
                    <Button1 value="addProfessorInfo" onClick={onChangePage}>교수정보 추가</Button1>
                    <Button2 value="ChangeProfessorInfo" onClick={onChangePage}>교수정보 조회 및 변경</Button2>
                    <GoBack onClick = {goBack}>뒤로가기</GoBack>
                    <GoMain onClick = {goMain}>메인으로</GoMain>
                </div>
            );
        }
        else if(type === "lecture") {
            return (
                <div>
                    <Button1 value="addLectureInfo" onClick={onChangePage}>강의정보 추가</Button1>
                    <Button2 value="changeLectureInfo" onClick={onChangePage}>강의정보 조회 및 변경</Button2>
                    <GoBack onClick = {goBack}>뒤로가기</GoBack>
                    <GoMain onClick = {goMain}>메인으로</GoMain>
                </div>
            );
        }
        else if(type === "addStudentInfo") {
            return (
                <div>
                    <TitleContainer>학생정보 추가</TitleContainer>
                    <GoBack onClick = {goBack}>뒤로가기</GoBack>
                    <AddSInfo />
                    <GoMain onClick = {goMain}>메인으로</GoMain>
                </div>
            );
        }
        else if(type === "addProfessorInfo") {
            return (
                <div>
                    <TitleContainer>교수정보 추가</TitleContainer>
                    <GoBack onClick = {goBack}>뒤로가기</GoBack>
                    <AddPInfo />
                    <GoMain onClick = {goMain}>메인으로</GoMain>
                </div>
            );
        }
        else if(type === "addLectureInfo") {
            return (
                <div>
                    <TitleContainer>강의정보 추가</TitleContainer>
                    <GoBack lecture onClick = {goBack}>뒤로가기</GoBack>
                    <AddLInfo />
                    <GoMain lecture onClick = {goMain}>메인으로</GoMain>
                </div>
            );
        }
    }
    return (
        <div>
            {diffPage(type)}
        </div>
    );
}