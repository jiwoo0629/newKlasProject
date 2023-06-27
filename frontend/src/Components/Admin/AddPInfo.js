import React, {useState} from 'react';
import axios from 'axios';
import styled from 'styled-components';
import Calendar from '../Calendar';

const PIdLayer = styled.div`
    position: absolute; left:350px; top:200px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const PId = styled.input`
    position: absolute; left:570px; top:200px;
    width:600px; height:40px;
    font-size:20px;
`

const NameLayer = styled.div`
    position: absolute; left:350px; top:260px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Name = styled.input`
    position: absolute; left:570px; top:260px;
    width:600px; height:40px;
    font-size:20px;
`

const DepLayer = styled.div`
    position: absolute; left:350px; top:320px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Dep = styled.input`
    position: absolute; left:570px; top:320px;
    width:600px; height:40px;
    font-size:20px;
`

const LabLayer = styled.div`
    position: absolute; left:350px; top:380px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Lab = styled.input`
    position: absolute; left:570px; top:380px;
    width:600px; height:40px;
    font-size:20px;
`

const SexLayer = styled.div`
    position: absolute; left:350px; top:440px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Sex = styled.select`
    position: absolute; left:570px; top:440px;
    width:200px; height:40px;
    font-size:20px;
`

const BirthLayer = styled.div`
    position: absolute; left:350px; top:500px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Birth = styled.div`
    position: absolute; left:570px; top:500px;
    width:300px; height:100px;
`

const PhoneLayer = styled.div`
    position: absolute; left:350px; top:560px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Phone = styled.input`
    position: absolute; left:570px; top:560px;
    width:600px; height:40px;
    font-size:20px;
`

const EmailLayer = styled.div`
    position: absolute; left:350px; top:620px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Email = styled.input`
    position: absolute; left:570px; top:620px;
    width:600px; height:40px;
    font-size:20px;
`

const Insert = styled.button`
    position: absolute; left:800px; top:750px;
    width:100px; height:50px;
    font-size:20px; font-weight:600; color:gray;
    border-radius:10px; border:2px solid gray;
`

function AddPInfo (props) {
    const [input, setInput] = useState({
        pid: "", name: "", dep: "", lab: "", phone: "", email: ""
    })
    const [sex, setSex] = useState("M")
    const {pid, name, dep, lab, phone, email} = input;
    const onChange = (e) => {
        const {name, value} = e.target;
        setInput ({
            ...input,
            [name]: value
        })
    }
    const onSelect = (e) => {
        setSex(e.target.value)
    }
    const onInsert = (e) => {
        if(pid === "") alert("학번을 입력하세요.")
        else if(isNaN(pid)) alert("잘못된 양식입니다. 학번을 다시 입력하세요.")
        else if(name === "") alert("이름을 입력하세요.")
        else if(dep === "") alert("학과를 입력하세요.")
        else if(dep !== "컴퓨터정보공학부") { //학부 리스트에 존재하는지 안하는지 확인
            alert("존재하지 않는 학과입니다. 학과를 다시 입력하세요.")
        }
        else if(lab === "") alert("연구실을 입력하세요.")
        else {
            if(window.confirm("정보를 저장하시겠습니까?")) {
                //정보저장 후 메인으로 이동
                axios.post("http://localhost:9000/professor/enroll", {
                    pid : pid,
                    name : name,
                    dep : dep,
                    lab : lab,
                    sex : sex,
                    phone : phone,
                    email : email,
                    birth : birth
                })
                .then((res) => {
                    alert("저장이 완료되었습니다.");
                    console.log(res);
                    //메인으로 이동
                    props.getType("main");
                })
                .catch((error) => {console.log(error.config.data)})
            }

        }
    }
    const [birth, setBirth] = useState(new Date());
    const getBirth = (date) => {
        setBirth(date);
    }

    return (
        <div>
            <PIdLayer>학번: </PIdLayer>
            <PId name="pid" value={pid} placeholder="학번" onChange={onChange} />
            <NameLayer>이름: </NameLayer>
            <Name name="name" value={name} placeholder="이름" onChange={onChange} />
            <DepLayer>학과: </DepLayer>
            <Dep name="dep" value={dep} placeholder="학과" onChange={onChange} />
            <LabLayer>연구실: </LabLayer>
            <Lab name="lab" value={lab} placeholder="연구실" onChange={onChange} />
            <SexLayer>성별: </SexLayer>
            <Sex name="sex" value={sex} onChange={onSelect}>
                <option value="M" key="M">남</option>
                <option value="W" key="W">여</option>
            </Sex>
            <BirthLayer>생일: </BirthLayer>
            <Birth><Calendar date="" getBirth={getBirth}/></Birth>
            <PhoneLayer>연락처(선택): </PhoneLayer>
            <Phone name="phone" value={phone} placeholder="연락처 (xxx-xxxx-xxxx 꼴로 입력해주세요)" onChange={onChange} />
            <EmailLayer>이메일(선택): </EmailLayer>
            <Email name="email" value={email} placeholder="이메일" onChange={onChange} />
            <Insert onClick={onInsert}>정보저장</Insert>
        </div>
    );
}

export default AddPInfo;