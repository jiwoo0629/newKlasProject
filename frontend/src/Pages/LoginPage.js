import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import styled from 'styled-components';
import Modal from 'react-modal';
import background from '../images/login_background.png';
import FindID from '../Components/Login/FindID';
import FindPW from '../Components/Login/FindPW';

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
const ChangePw = styled.button`
    position:absolute; top:60px;
    width:300px; height:40px;
    border:0px; border-radius:5px;
    background:gray; font-size:18px; font-weight:600; color:white;
    display:flex; justify-content:center; align-items:center;
`

const Warning = styled.div`
    position:absolute; left:37%; top: 460px;
    width:400px; height:50px;
    display:flex; justify-content: center; align-items: center;
    background: white; color: red; font-size: 16px; font-weight:600px;
`

export default function LoginPage () {
    const navigate = useNavigate();
    const [input, setInput] = useState({
        id: "", pw: ""
    })
    const {id, pw, name, dep} = input;
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
        //로그인 실패 시, setFail(fail + 1) / 로그인 성공 시, setFail(0)
        if(checked === true) {
            if(localStorage.getItem("saveID") !== undefined) localStorage.removeItem("saveId")
            localStorage.setItem("saveID", id)
        }
        navigate('/main');
    }
    const [ModalIsOpen, setModalIsOpen] = useState(false);
    const [IDModal, setIDModal] = useState(false);
    const [PWModal, setPWModal] = useState(false);
    const [ChangePWModal, setChangePWModal] = useState(false);
    const getModalIsOpen = (modal) => { setModalIsOpen(modal); }
    const getIDModal = (modal) => { setIDModal(modal); }
    const getPWModal = (modal) => { setPWModal(modal); }
    const getChangePWModal = (modal) => { setChangePWModal(modal); }
    const diffModal = () => {
        if(IDModal) {
            return (
                <FindID getModalIsOpen={getModalIsOpen} getIDModal={getIDModal} />
            );
        }
        else if(PWModal) {
            return (
                <FindPW getModalIsOpen={getModalIsOpen} getPWModal={getPWModal} title="비밀번호 찾기" />
            );
        }
        else if(ChangePWModal) {
            return (
                <FindPW getModalIsOpen={getModalIsOpen} getPWModal={getChangePWModal} title="비밀번호 최초등록"/>
            );
        }
    }
    return (
        <Container>
            <Title>NEW KLAS</Title>
            <Div1>
                <Input name="id" value={id} placeholder="ID" onChange={onChange} />
                <Input type="password" name="pw" value={pw} placeholder="PASSWORD" onChange={onChange} />
            </Div1>
            <Div2>
                <Checkbox type="checkbox" name="SaveID" value={checked} onClick={onSave}/> &nbsp;&nbsp;아이디 저장
                <Login onClick={onLogin}>로그인</Login>
            </Div2>
            <Div3>
                <Find onClick={() => {
                    setModalIsOpen(true);
                    setIDModal(true);
                }}>개인번호 찾기</Find>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <Find onClick={() => {
                    setModalIsOpen(true);
                    setPWModal(true);
                }}>비밀번호 찾기</Find>
                <ChangePw onClick={() => {
                    setModalIsOpen(true);
                    setChangePWModal(true);
                }}>비밀번호 최초등록</ChangePw>
                <Modal style={{
                    overlay: {
                      position: 'fixed',
                      top: 0, left: 0, right: 0, bottom: 0,
                      backgroundColor: 'rgba(255, 255, 255, 0.75)'
                    },
                    content: {
                      position: 'absolute', top: '150px', left: '25%',
                      width: '800px', height: '500px',
                      background: '#fff', borderRadius: '4px', padding: '20px',
                      overflow: 'auto', outline: 'none'
                    }
                }} isOpen={ModalIsOpen} onRequestClose={() => {
                    setModalIsOpen(false);
                    if(IDModal) setIDModal(false);
                    else if(PWModal) setPWModal(false);
                    else if(ChangePWModal) setChangePWModal(false);
                }}>
                    {diffModal()}
                </Modal>
            </Div3>
            <Warning>
                * 비밀번호 오류 5회 이상 로그인 제한 <br />
                * 최초 로그인 시, 비밀번호 최초등록을 먼저 해주세요
            </Warning>
        </Container>
    );
}