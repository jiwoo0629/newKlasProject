import React, {useState, useRef} from 'react';
import styled from 'styled-components';

const Container = styled.div`
    width:100%; height: 1250px;
`

const LnumLayer = styled.div`
    position: absolute; left:350px; top:200px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const Lnum = styled.input`
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

const ClassLayer = styled.div`
    position: absolute; left:350px; top:320px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const Class = styled.select`
    position: absolute; left:570px; top:320px;
    width:150px; height:40px;
    font-size:20px;
`

const YearSemesterLayer = styled.div`
    position: absolute; left:350px; top:380px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const Year = styled.input`
    position: absolute; left:570px; top:380px;
    width:200px; height:40px;
    font-size:20px;
`
const Semester = styled.input`
    position: absolute; left:890px; top:380px;
    width:200px; height:40px;
    font-size:20px;
`

const ProfessorLayer = styled.div`
    position: absolute; left:350px; top:440px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const PID = styled.input`
    position: absolute; left:570px; top:440px;
    width:280px; height:40px;
    font-size:20px;
`
const Pname = styled.input`
    position: absolute; left:890px; top:440px;
    width:280px; height:40px;
    font-size:20px;
`

const LtimeLayer = styled.div`
    position: absolute; left:350px; top:500px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const Ltime1_day = styled.select`
    position: absolute; left:570px; top:500px;
    width:140px; height:40px; font-size:20px;
`
const Ltime1_time = styled.select`
    position: absolute; left:720px; top:500px;
    width:140px; height:40px; font-size:20px;
`
const Ltime2_day = styled.select`
    position: absolute; left:890px; top:500px;
    width:140px; height:40px; font-size:20px;
`
const Ltime2_time = styled.select`
    position: absolute; left:1040px; top:500px;
    width:140px; height:40px; font-size:20px;
`

const LroomLayer = styled.div`
    position: absolute; left:350px; top:560px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const Lroom = styled.input`
    position: absolute; left:570px; top:560px;
    width:600px; height:40px;
    font-size:20px;
`

const EnrollLayer = styled.div`
    position: absolute; left:350px; top:620px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const Enroll = styled.input`
    position: absolute; left:570px; top:620px;
    width:200px; height:40px;
    font-size:20px;
`

const LinfoLayer = styled.div`
    position: absolute; left:350px; top:680px;
    width:200px; height:50px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const Linfo = styled.textarea`
    position: absolute; left:570px; top:680px;
    width:600px; height:200px;
    border: 1px solid black; border-radius: 4px; font-size:20px;
`

const ObjMethodLayer = styled.div`
    position: absolute; left:400px; top:900px;
    width:150px; height:100px;
    font-size:30px; font-weight:600;
    text-align: right;
`
const ObjMethod = styled.textarea`
    position: absolute; left:570px; top:900px;
    width:600px; height:200px;
    border: 1px solid black; border-radius: 4px; font-size:20px;
`

const Insert = styled.button`
    position: absolute; left:800px; top:1150px;
    width:100px; height:50px;
    font-size:20px; font-weight:600; color:gray;
    border-radius:10px; border:2px solid gray;
    margin-bottom : 50px;
`

function AddLInfo () {
    const [input, setInput] = useState({
        lnum: "", name: "", class: "", year: "", semester: "",
        pid: "", pname: "", lroom: "", enroll: "", linfo: "", obj_method: ""
    })
    const {lnum, name, year, semester, pid, pname, lroom, enroll, linfo, obj_method} = input;
    const onChange = (e) => {
        const {name, value} = e.target;
        setInput ({
            ...input,
            [name]: value
        })
    }
    const [select, setSelect] = useState({
        classification: "none",
        ltime1_day: "no", ltime1_time: "", ltime2_day: "no", ltime2_time: ""
    })
    const {classification, ltime1_day, ltime1_time, ltime2_day, ltime2_time} = select;
    const time1Ref = useRef(null);
    const time2Ref = useRef(null);
    function handleFocus(name) {
        var Ref = (name === "ltime1_day") ? time1Ref : time2Ref;
        Ref.current.disabled = false;
        Ref.current.focus();
    }
    function handleReset(name) {
        var Ref = (name === "ltime1_day") ? time1Ref : time2Ref;
        Ref.current.disabled = true;
        Ref.current.value = "";
    }
    const onSelect = (e) => {
        const {name, value} = e.target;
        setSelect({
            ...select,
            [name]: value
        })
        if(name === "ltime1_day" || name === "ltime2_day") {
            if(value === "no" || value === "x") handleReset(name);
            else handleFocus(name);
        }
    }
    const onInsert = (e) => {
        if(lnum === "") alert("학정번호를 입력하세요.")
        else if(lnum.length != 14) alert("잘못된 양식입니다. 학정번호를 다시 입력하세요.");
        else if(name === "") alert("교과목명을 입력하세요.")
        else if(classification === "") alert("이수구분을 입력하세요.")
        else if(year === "" || semester === "") alert("년도학기를 입력하세요")
        else if(isNaN(pid)) alert("잘못된 양식입니다. 학번을 다시 입력하세요.")
        else if(pname === "") alert("교수명을 입력하세요.")
        //pid와 pname이 가리키는 사람이 같은지 확인
        else if(enroll === "") alert("재적인원을 입력하세요.")
        else {
            if(window.confirm("정보를 저장하시겠습니까?")) {
                //정보저장 후 메인으로 이동
            }
        }
    }

    return (
        <Container>
            <LnumLayer>학정번호: </LnumLayer>
            <Lnum name="lnum" value={lnum} placeholder="학정번호 ('####-#-####-##' 꼴로 입력해주세요)" onChange={onChange} />
            <NameLayer>교과목명: </NameLayer>
            <Name name="name" value={name} placeholder="교과목명" onChange={onChange} />
            <ClassLayer>이수구분: </ClassLayer>
            <Class name="class" value={classification} onChange={onSelect}>
                <option value="none" >=== 선 택 ===</option>
                <option value="MR" key = "MR">전필</option>
                <option value="MS" key = "MS">전선</option>
                <option value="LR" key = "LR">교필</option>
                <option value="LS" key = "LS">교선</option>
                <option value="BR" key = "BR">기필</option>
                <option value="BS" key = "BS">기선</option>
            </Class>
            <YearSemesterLayer>년도학기: </YearSemesterLayer>
            <Year name="year" value={year} placeholder="년도" onChange={onChange} />
            <Semester name="semester" value={semester} placeholder="학기" onChange={onChange} />
            <ProfessorLayer>교수: </ProfessorLayer>
            <PID name="pid" value={pid} placeholder="학번" onChange={onChange} />
            <Pname name="pname" value={pname} placeholder="이름" onChange={onChange} />
            <LtimeLayer>강의시간: </LtimeLayer>
            <Ltime1_day name="ltime1_day" value={ltime1_day} placeholder="요일1" onChange={onSelect}>
                <option value="x">== 선 택 ==</option>
                <option value="mo">월</option>
                <option value="tu">화</option>
                <option value="we">수</option>
                <option value="th">목</option>
                <option value="fr">금</option>
                <option value="sa">토</option>
            </Ltime1_day>
            <Ltime1_time name="ltime1_time" value={ltime1_time} placeholder="시간1" onChange={onSelect} ref={time1Ref} disabled>
                <option value="">== 선 택 ==</option>
                <option value="0">0교시</option>
                <option value="1">1교시</option>
                <option value="2">2교시</option>
                <option value="3">3교시</option>
                <option value="4">4교시</option>
                <option value="5">5교시</option>
                <option value="6">6교시</option>
            </Ltime1_time>
            <Ltime2_day name="ltime2_day" value={ltime2_day} placeholder="요일2" onChange={onSelect}>
                <option value="x">== 선 택 ==</option>
                <option value="no">해당없음</option>
                <option value="mo">월</option>
                <option value="tu">화</option>
                <option value="we">수</option>
                <option value="th">목</option>
                <option value="fr">금</option>
                <option value="sa">토</option>
            </Ltime2_day>
            <Ltime2_time name="ltime2_time" value={ltime2_time} placeholder="시간2" onChange={onSelect} ref={time2Ref} disabled>
                <option value="">== 선 택 ==</option>
                <option value="0">0교시</option>
                <option value="1">1교시</option>
                <option value="2">2교시</option>
                <option value="3">3교시</option>
                <option value="4">4교시</option>
                <option value="5">5교시</option>
                <option value="6">6교시</option>
            </Ltime2_time>
            <LroomLayer>강의실: </LroomLayer>
            <Lroom name="lroom" value={lroom} placeholder="강의실" onChange={onChange} />
            <EnrollLayer>재적인원: </EnrollLayer>
            <Enroll name="enroll" value={enroll} placeholder="재적인원" onChange={onChange} />
            <LinfoLayer>교과목개요: </LinfoLayer>
            <Linfo name="linfo" value={linfo} placeholder="교과목개요" onChange={onChange} />
            <ObjMethodLayer>학습목표 및 학습방법: </ObjMethodLayer>
            <ObjMethod name="obj_method" value={obj_method} placeholder="학습목표 및 학습방법" onChange={onChange} />
            <Insert onClick={onInsert}>정보저장</Insert>
            <p /><br />
        </Container>
    );
}

export default AddLInfo;