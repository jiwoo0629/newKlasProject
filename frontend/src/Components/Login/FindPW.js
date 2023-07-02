import React, {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';
import Calendar from '../Calendar';

const Upper = styled.div`
    position: absolute; left:0px; top:0px;
    width:100%; height:40px;
    display:flex; align-items:center;
    padding: 11px 30px; border:0px;
    font-size:18px; font-weight:600;
    background: rgba(195,195,195,0.3);
`
const Close = styled.button`
    position: absolute; left:720px; top:10px;
    width:80px; height:40px;
    display:flex; justify-content:center; align-items:center;
    font-size:20px; font-weight:600;
    border:2px solid black; border-radius:5px;
`
const Caution = styled.div`
    position: absolute; top:100px; left:10%;
    width:80%; height:80px;
    font-size:18px;
`

const Table = styled.table`
    position:absolute; top:200px; left:10%;
    width:77%; border:1px solid gray;
    font-size:18px;
`
const Tr = styled.tr`
    height:50px; border:1px solid gray;
`
const Td_Title = styled.td`
    width:150px; border:1px solid gray;
    text-align:center; background: rgba(195,195,195,0.3);
`
const Td_Input = styled.td`
    padding-left:15px; border:1px solid gray;
`
const SelectRole = styled.select`
    width:200px; height:30px;
    border:1px solid black; border-radius:5px;
    font-size:18px; padding-left:10px;
`
const Input = styled.input`
    width:188px; height:30px;
    border:1px solid black; border-radius:5px;
    font-size:18px; padding-left:10px;
`
const Next = styled.button`
    position:absolute; left:40%; top:440px;
    width:20%; height:50px;
    display:flex; justify-content:center; align-items:center;
    font-size:20px; font-weight:600;
    border:2px solid black; border-radius:10px;
`

export default function FindPW (props) {
    const [input, setInput] = useState({
        id: "", name: ""
    });
    const {id, name} = input;
    const onChange = (e) => {
        const {name, value} = e.target;
        setInput({
            ...input,
            [name]: value
        })
    }
    const [role, setRole] = useState("stud");
    const onSelectRole = (e) => {
        setRole(e.target.value);
    }
    const [birth, setBirth] = useState(new Date());
    const getBirth = (date) => {
        setBirth(date);
    }
    const onNext = () => {
        if(id === "") alert("개인번호(학번)을 입력하세요.")
        else if(name === "") alert("성명을 입력하세요.")
        else {
            var api;
            var params;
            if(role === "stud") {
                api = "http://localhost:9000/student/findByIdNameBirth";
                params = {sid : id, name: name, birth: birth}
            }
            else {
                api = "http://localhost:9000/professor/findByIdNameBirth";
                params = {pid: id, name: name, birth: birth}
            }
            axios.get(api, { params: params })
            .then((res) => {
                if(window.confirm("임시 비밀번호를 발급받으시겠습니까?\n\n비밀번호를 발급받으면 \n기존 비밀번호는 더이상 사용할 수 없습니다.")) {
                    axios.post("http://localhost:9000/user/resetPW",
                        {},
                        {params : {id: res.data}
                    })
                    .then((res) => {
                        alert("임시 비밀번호를 발급했습니다.\n임시 비밀번호는 '00000000'입니다.\n로그인 화면으로 이동합니다.");
                        props.getModalIsOpen(false);
                        props.getPWModal(false);
                    })
                    .catch((error) => {console.log(error)});
                }
            })
            .catch((error) => {console.log(error)});
        }
    }
    return (
        <>
            <Upper>비밀번호 찾기</Upper>
            <Close onClick={() => {
                props.getModalIsOpen(false);
                props.getPWModal(false);
            }}>X 닫기</Close>
            <Caution>
                1. 사용자 구분, 개인번호(학번), 성명, 생년월일을 입력 후 <b>[다음]</b> 버튼을 누르면,<br />
                   &nbsp;&nbsp;&nbsp;&nbsp;<b>임시 비밀번호</b>가 발급됩니다.<br />
                2. 임시 비밀번호를 이용해 로그인한 후, <b>비밀번호를 변경</b>하셔야 정상적으로 이용 가능합니다.
            </Caution>
            <Table>
                <Tr>
                    <Td_Title>사용자 구분</Td_Title>
                    <Td_Input>
                        <SelectRole value={role} onChange={onSelectRole}>
                            <option value="stud">학생</option>
                            <option value="prof">교수</option>
                        </SelectRole>
                    </Td_Input>
                </Tr>
                <Tr>
                    <Td_Title>개인번호(학번)</Td_Title>
                    <Td_Input>
                        <Input name="id" value={id} placeholder="개인번호(학번)" onChange={onChange} />
                    </Td_Input>
                </Tr>
                <Tr>
                    <Td_Title>성명</Td_Title>
                    <Td_Input>
                        <Input name="name" value={name} placeholder="성명" onChange={onChange} />
                    </Td_Input>
                </Tr>
                <Tr>
                    <Td_Title>생년월일</Td_Title>
                    <Td_Input>
                        <Calendar date="" getBirth={getBirth} />
                    </Td_Input>
                </Tr>
            </Table>
            <Next onClick={onNext}>다음</Next>
        </>
    );
}