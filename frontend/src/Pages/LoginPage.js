import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import styled from 'styled-components';
import Modal from 'react-modal';
import background from '../images/login_background.png';

const Container = styled.div`
    background-image: linear-gradient(rgba(0,0,0,0.75), rgba(0,0,0,0.75)), url(${background});
    margin:0px; width:100vw; height:100vh;
    background-position : top center;
    background-size: cover;
    background-repeat: no-repeat;
    background-attachment : fixed;
`
const Title = styled.div`
    position: absolute; left:40%; top:50px;
    width:300px; height:100px;
    display:flex; justify-content: center; text-align: center;
    font-size:40px; font-weight:600; color:white;
`

const Div1 = styled.div`
    position: absolute; left:40%; top:150px;
    width:300px; height:100px;
    display:grid; justify-content: center; align-items: center;
`
const Input = styled.input`
    width:300px; height:30px;
    border: 0px; border-radius:15px;
    background-color: gray; color: white; font-size:18px;
    padding: 6px 15px; margin-bottom:5px;
    &::placeholder{
		color: white;
	}
`

const Div2 = styled.div`
    position: absolute; left:40%; top:270px;
    width:300px; height:50px;
    color:white; font-size:16px; font-weight:600;
`
const Checkbox = styled.input`
    position: absolute; top:0px; left:-15px;
`
const Login = styled.button`
    position: absolute; left:100px; top:-10px;
    width:210px; height:40px;
    border:0px; border-radius:15px;
    background: brown; font-size:18px; font-weight:600; color:white;
`

const Div3 = styled.div`
    position: absolute; left:40%; top:330px;
    width:300px; height:50px;
    display:flex; justify-content: center; align-items: center;
`
const Find = styled.button`
    width:150px; height:40px;
    border:0px; border-radius:5px;
    background:gray; font-size:18px; font-weight:600; color:white;
    display:flex; justify-content:center; align-items:center;
`

const Warning = styled.div`
    position:absolute; left:40%; top: 400px;
    width:300px; height:50px;
    display:flex; justify-content: center; align-items: center;
    background: white; color: red; font-size: 16px; font-weight:600px;
`

export default function LoginPage () {
    const [input, setInput] = useState({ id: "", pw: "" })
    const {id, pw} = input;
    const onChange = (e) => {
        const {name, value} = e.target;
        setInput({
            ...input,
            [name]: value
        })
    }
    const [checked, setChecked] = useState(false);
    const onSave = (e) => {
        if(e.target.value === false) setChecked(true);
        else setChecked(false);
    }
    const [fail, setFail] = useState(0);
    const onLogin = () => {
        //로그인 처리
        //로그인 싶패 시, setFail(fail + 1) / 로그인 성공 시, setFail(0)
        if(checked === true) {
            if(localStorage.getItem("saveID") !== undefined) localStorage.removeItem("saveId")
            localStorage.setItem("saveID", id)
        }
    }
    const [IDModalIsOpen, setIDModalIsOpen] = useState(false);
    const [PWModalIsOpen, setPWModalIsOpen] = useState(false);
    const diffModal = () => {
        if(IDModalIsOpen && !PWModalIsOpen) {
            return (
                <Modal style={{
                    overlay: {
                      position: 'fixed',
                      top: 0, left: 0, right: 0, bottom: 0,
                      backgroundColor: 'rgba(255, 255, 255, 0.75)'
                    },
                    content: {
                      position: 'absolute', top: '150px', left: '20%',
                      width: '1000px', height: '500px',
                      background: '#fff', borderRadius: '4px', padding: '20px',
                      overflow: 'auto', outline: 'none'
                    }
                }} isOpen={true} onRequestClose={() => setIDModalIsOpen(false)}>
                    <button onClick={()=> setIDModalIsOpen(false)}>닫기</button>
                </Modal>
            );
        }
        else if(!IDModalIsOpen && PWModalIsOpen) {
            return (
                <Modal style={{
                    overlay: {
                      position: 'fixed',
                      top: 0, left: 0, right: 0, bottom: 0,
                      backgroundColor: 'rgba(255, 255, 255, 0.75)'
                    },
                    content: {
                      position: 'absolute', top: '150px', left: '20%',
                      width: '1000px', height: '500px',
                      background: '#fff', borderRadius: '4px', padding: '20px',
                      overflow: 'auto', outline: 'none'
                    }
                }} isOpen={true} onRequestClose={() => setPWModalIsOpen(false)}>
                    <button onClick={()=> setPWModalIsOpen(false)}>닫기</button>
                </Modal>
            );
        }
    }
    return (
        <Container>
            <Title>New Klas</Title>
            <Div1>
                <Input name="id" value={id} placeholder="ID" onChange={onChange} />
                <Input name="pw" value={pw} placeholder="PASSWORD" onChange={onChange} />
            </Div1>
            <Div2>
                <Checkbox type="checkbox" name="SaveID" value={checked} onClick={onSave}/> &nbsp;&nbsp;아이디 저장
                <Login onClick={onLogin}>로그인</Login>
            </Div2>
            <Div3>
                <Find onClick={() => setIDModalIsOpen(true)}>개인번호 찾기</Find>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <Find onClick={() => setPWModalIsOpen(true)}>비밀번호 찾기</Find>
                {diffModal()}
            </Div3>
            <Warning>
                * 비밀번호 오류 5회 이상 로그인 제한 *
            </Warning>
        </Container>
    );
}