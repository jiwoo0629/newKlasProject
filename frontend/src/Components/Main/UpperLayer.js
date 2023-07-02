import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import styled from 'styled-components';
import axios from 'axios';
import { VscMenu } from 'react-icons/vsc';
import { MdSettings, MdLogout } from 'react-icons/md';
import Toggle from './Toggle';

const Container = styled.div`
    position:fixed; width:100%; height:70px;
    display:flex; justify-content:center; align-items:center;
    background: rgba(32, 201, 151, 0.7); color:white;
    z-index:0;
`
const Logo = styled.button`
    position:absolute; left:240px;
    width: 200px; height:50px;
    display:flex; justify-content:center; align-items:center;
    font-size:30px; font-weight:600;
    background:rgba(32, 201, 151, 0); color:white;
    border:0px;

`
const Check = styled.button`
    position:absolute; left:450px;
    display:flex; justify-content:center; align-items:center;
    background: rgba(32, 201, 151, 0.7); color:white;
    border:2px solid white; border-radius:3px;
`
const Info = styled.button`
    position:absolute; left:1000px;
    width:250px; height:50px;
    display:flex; align-items:center;
    font-size:20px; font-weight:600;
    background:rgba(32, 201, 151, 0); color:white;
    border:0px;
`
const Logout = styled.button`
    position:absolute; left:1300px;
    width:120px; height:50px;
    display:flex; align-items:center; justify-content:center;
    font-size:20px; font-weight:600;
    background:rgba(32, 201, 151, 0); color:white;
    border:0px;
`

const userInfo = {
    name: "정지우", id: "2018202061"
}
export default function UpperLayer (props) {
    const navigate = useNavigate();
    const [isCheck, setIsCheck] = useState(false);
    const onMain = () => {
        navigate(`/main`);
    }
    const onMyInfo = () => {
        navigate(`/myInfo`);
    }
    const onLogout = () => {
        if(window.confirm("로그아웃 하시겠습니까?")) {
            alert("로그아웃되었습니다.\n로그인 화면으로 이동합니다.")
            navigate(`/`);
        }
    }
    return (
        <Container>
            <Logo onClick={onMain}>NEW KLAS</Logo>
            <Check onClick={() => setIsCheck(!isCheck)}><VscMenu size="35"/></Check>
            {
                isCheck && (
                    <Toggle />
                )
            }
            <Info onClick={onMyInfo}>
                <MdSettings /> &nbsp;{userInfo.name}({userInfo.id})
            </Info>
            <Logout onClick={onLogout}>
                Logout &nbsp; <MdLogout size="20" />
            </Logout>
        </Container>
    );
}