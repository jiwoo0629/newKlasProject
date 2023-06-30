import React, {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';
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

function UpdatePInfo () {
    const [type, setType] = useState("search");
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
    const [birth, setBirth] = useState(new Date());
    const getBirth = (date) => {
        setBirth(date);
        console.log(date);
    }
    var btn_name;
    if(type === "search") btn_name = "조회하기";
    else if(type === "view") btn_name = "정보수정";
    else btn_name = "정보저장";

    const onSearch = () => {
        //학번 이용해서 정보 조회
        //있을 경우 정보 조회 화면 이동. 없을 경우 에러 메시지
        axios.get("http://localhost:9000/professor/findByIdName", {
            params: {pid: pid, name: name}
        })
        .then((res) => {
            console.log(res);
            setInput(res.data);
            setSex(res.data.sex);
            setBirth(res.data.birth);
            setType("view")
        })
        .catch((error) => {
            console.log(error);
            alert("존재하지 않는 사용자입니다.")
        });
    }
    const goUpdate = () => {
        if(window.confirm("정보를 수정하시겠습니까?"))
            setType("update");
    }
    const onUpdate = (e) => {
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
                axios.post("http://localhost:9000/professor/update", {
                    pid : pid,
                    name : name,
                    dep : dep,
                    lab : lab,
                    sex : sex,
                    phone : phone,
                    email : email,
                    birth : birth
                })
                .then(() => {
                    //정보저장 후 메인으로 이동
                    alert("정보가 수정되었습니다.")
                    setType("view");
                })
                .catch((error) => {console.log(error)})
            }
        }
    }

    const diffPage = () => {
        if(type === "search") {
            return (
                <div>
                    <PIdLayer>학번: </PIdLayer>
                    <PId name="pid" value={pid} placeholder="학번" onChange={onChange} />
                    <NameLayer>이름: </NameLayer>
                    <Name name="name" value={name} placeholder="이름" onChange={onChange} />
                    <Insert onClick={onSearch}>{btn_name}</Insert>
                </div>
            );
        }
        else if(type === "view" || type === "update") {
            const diffFunc = () => {
                if(type === "view") goUpdate();
                else onUpdate();
            }
            return (
                <div>
                    <PIdLayer>학번: </PIdLayer>
                    <PId name="sid" value={pid} placeholder="학번" onChange={onChange} disabled={type==="view" ? true : false} />
                    <NameLayer>이름: </NameLayer>
                    <Name name="name" value={name} placeholder="이름" onChange={onChange} disabled={type==="view" ? true : false} />
                    <DepLayer>학과: </DepLayer>
                    <Dep name="dep" value={dep} placeholder="학과" onChange={onChange} disabled={type==="view" ? true : false} />
                    <LabLayer>연구실: </LabLayer>
                    <Lab name="lab" value={lab} placeholder="연구실" onChange={onChange} disabled={type==="view" ? true : false} />
                    <SexLayer>성별: </SexLayer>
                    <Sex name="sex" value={sex} onChange={onSelect} disabled={type==="view" ? true : false}>
                        <option value="M" key="M">남</option>
                        <option value="W" key="W">여</option>
                    </Sex>
                    <BirthLayer>생일: </BirthLayer>
                    <Birth><Calendar date={birth} getBirth={getBirth} type={type} /></Birth>
                    <PhoneLayer>연락처(선택): </PhoneLayer>
                    <Phone name="phone" value={phone} placeholder="연락처 (xxx-xxxx-xxxx 꼴로 입력해주세요)" onChange={onChange} disabled={type==="view" ? true : false} />
                    <EmailLayer>이메일(선택): </EmailLayer>
                    <Email name="email" value={email} placeholder="이메일" onChange={onChange} disabled={type==="view" ? true : false} />
                    <Insert onClick={diffFunc}>{btn_name}</Insert>
                </div>
            );
        }
    }

    return (
        <div>
            {diffPage()}
        </div>
    );
}

export default UpdatePInfo;