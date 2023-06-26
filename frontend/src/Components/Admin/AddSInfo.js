import React, {useState} from 'react';
import axios from 'axios';
import styled from 'styled-components';
import Calendar from '../Calendar';

const SIdLayer = styled.div`
    position: absolute; left:350px; top:200px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const SId = styled.input`
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

const GradeLayer = styled.div`
    position: absolute; left:350px; top:380px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Grade = styled.input`
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
    width:300px; height:40px;
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

const AddrLayer = styled.div`
    position: absolute; left:350px; top:680px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`

const Addr = styled.input`
    position: absolute; left:570px; top:680px;
    width:600px; height:40px;
    font-size:20px;
`

const Insert = styled.button`
    position: absolute; left:800px; top:750px;
    width:100px; height:50px;
    font-size:20px; font-weight:600; color:gray;
    border-radius:10px; border:2px solid gray;
`

function AddSInfo () {
    const [input, setInput] = useState({
        sid: "", name: "", dep: "", grade: "", phone: "", email: "", addr: ""
    })
    const [sex, setSex] = useState("M")
    const {sid, name, dep, grade, phone, email, addr} = input;
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
    const onInsert = () => {
        if(sid === "") alert("학번을 입력하세요.")
        else if(sid.length !== 10 || isNaN(sid)) alert("잘못된 양식입니다. 학번을 다시 입력하세요.")
        else if(name === "") alert("이름을 입력하세요.")
        else if(dep === "") alert("학과를 입력하세요.")
        else if(dep !== "컴퓨터정보공학부") { //학부 리스트에 존재하는지 안하는지 확인
            alert("존재하지 않는 학과입니다. 학과를 다시 입력하세요.")
        }
        else if(grade === "") alert("학년을 입력하세요.")
        else {
            if(window.confirm("정보를 저장하시겠습니까?")) {
                //정보저장 후 메인으로 이동
                axios.post("http://localhost:9000/student/enroll", {
                    sid : sid,
                    name : name,
                    dep : dep,
                    grade : parseInt(grade),
                    sex : sex,
                    phone : phone,
                    email : email,
                    addr : addr,
                    birth : birth
                })
                .then((res) => {
                    alert("저장이 완료되었습니다.");
                    console.log(res);
                    //메인으로 이동
                })
                .catch((error) => {console.log(error)})
            }
        }
    }
    const [birth, setBirth] = useState(new Date());
    const getBirth = (date) => {
        setBirth(date);
    }

    return (
        <div>
            <SIdLayer>학번: </SIdLayer>
            <SId name="sid" value={sid} placeholder="학번" onChange={onChange} />
            <NameLayer>이름: </NameLayer>
            <Name name="name" value={name} placeholder="이름" onChange={onChange} />
            <DepLayer>학과: </DepLayer>
            <Dep name="dep" value={dep} placeholder="학과" onChange={onChange} />
            <GradeLayer>학년: </GradeLayer>
            <Grade name="grade" value={grade} placeholder="학년" onChange={onChange} />
            <SexLayer>성별: </SexLayer>
            <Sex name="sex" value={sex} onChange={onSelect}>
                <option value="M" key="M">남</option>
                <option value="W" key="W">여</option>
            </Sex>
            <BirthLayer>생일: </BirthLayer>
            <Birth><Calendar date="" getBirth={getBirth} /></Birth>
            <PhoneLayer>연락처(선택): </PhoneLayer>
            <Phone name="phone" value={phone} placeholder="연락처 (xxx-xxxx-xxxx 꼴로 입력해주세요)" onChange={onChange} />
            <EmailLayer>이메일(선택): </EmailLayer>
            <Email name="email" value={email} placeholder="이메일" onChange={onChange} />
            <AddrLayer>주소(선택): </AddrLayer>
            <Addr name="addr" value={addr} placeholder="주소" onChange={onChange} />
            <Insert onClick={onInsert}>정보저장</Insert>
        </div>
    );
}

export default AddSInfo;