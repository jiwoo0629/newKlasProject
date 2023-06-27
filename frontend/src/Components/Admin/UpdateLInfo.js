import React, {useState, useRef} from 'react';
import styled from 'styled-components';
import axios from 'axios';

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
const Ltime1_Day = styled.select`
    position: absolute; left:570px; top:500px;
    width:140px; height:40px; font-size:20px;
`
const Ltime1_Time = styled.select`
    position: absolute; left:720px; top:500px;
    width:140px; height:40px; font-size:20px;
`
const Ltime2_Day = styled.select`
    position: absolute; left:890px; top:500px;
    width:140px; height:40px; font-size:20px;
`
const Ltime2_Time = styled.select`
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
    position: absolute; left:800px;
    top: ${props => props.search ? '750px' : '1150px'};
    width:100px; height:50px;
    font-size:20px; font-weight:600; color:gray;
    border-radius:10px; border:2px solid gray;
    margin-bottom : 50px;
`

function UpdateLInfo (props) {
    const [type, setType] = useState("search");
    const [input, setInput] = useState({
        lnum: "", name: "", lyear: "", lsemester: "",
        pid: "", pname: "", lroom: "", enroll: "", linfo: "", obj_method: ""
    })
    const {lnum, name, lyear, lsemester, pid, pname, lroom, enroll, linfo, obj_method} = input;
    const onChange = (e) => {
        const {name, value} = e.target;
        setInput ({
            ...input,
            [name]: value
        })
    }
    const [classification, setClassification] = useState("none");
    const [select, setSelect] = useState({
        lt1_day: "x", lt1_time: "", lt2_day: "x", lt2_time: ""
    })
    const {lt1_day, lt1_time, lt2_day, lt2_time} = select;
    const time1Ref = useRef(null);
    const time2Ref = useRef(null);
    function handleFocus(name) {
        var Ref = (name === "lt1_day") ? time1Ref : time2Ref;
        Ref.current.disabled = false;
        Ref.current.focus();
    }
    function handleReset(name) {
        var Ref = (name === "lt1_day") ? time1Ref : time2Ref;
        Ref.current.disabled = true;
        Ref.current.value = "";
    }
    const onSelect = (e) => {
        const {name, value} = e.target;
        setSelect({
            ...select,
            [name]: value
        })
        if(name === "lt1_day" || name === "lt2_day") {
            if(value === "no" || value === "x") handleReset(name);
            else handleFocus(name);
        }
    }
    var btn_name;
    if(type === "search") btn_name = "조회하기";
    else if(type === "view") btn_name = "정보수정";
    else btn_name = "정보저장";

    function getLecture() {
        return axios.get("http://localhost:9000/lecture/get", {
            params: {lnum: lnum, name: name}
        })
    }
    function getLectureTime() {
        return axios.get("http://localhost:9000/lecture/getTime", {
            params: {lnum: lnum}
        })
    }
    const onSearch = () => {
        //학번 이용해서 정보 조회
        //있을 경우 정보 조회 화면 이동. 없을 경우 에러 메시지
        axios.all([getLecture(), getLectureTime()])
        .then(axios.spread((res1, res2) => {
            setInput(res1.data);
            setSelect(res2.data);
            setClassification(res1.data.classification);
            setType("view")
            props.getLt("view")
        }))
        .catch((error) => {
            console.log(error);
            alert("존재하지 않는 강의입니다.")
        })
    }
    const goUpdate = () => {
        if(window.confirm("정보를 수정하시겠습니까?")) {
            setType("update")
            props.getLt("update")
        }
    }
    const onUpdate = (e) => {
        if(lnum === "") alert("학정번호를 입력하세요.")
        else if(lnum.length !== 14) alert("잘못된 양식입니다. 학정번호를 다시 입력하세요.");
        else if(name === "") alert("교과목명을 입력하세요.")
        else if(lyear === "" || lsemester === "") alert("년도학기를 입력하세요")
        else if(isNaN(pid)) alert("잘못된 양식입니다. 학번을 다시 입력하세요.")
        else if(pname === "") alert("교수명을 입력하세요.")
        //pid와 pname이 가리키는 사람이 같은지 확인
        else if(lt1_day === "x" || lt1_time === "") alert("강의시간을 입력하세요.")
        else if(lroom === "") alert("강의실을 입력하세요.")
        else if(enroll === "") alert("재적인원을 입력하세요.")
        else {
            if(window.confirm("정보를 저장하시겠습니까?")) {
                axios.post("http://localhost:9000/lecture/update", {
                    lnum : lnum,
                    name : name,
                    classification : classification,
                    lyear : parseInt(lyear),
                    lsemester : parseInt(lsemester),
                    lroom : lroom,
                    pid : pid,
                    pname : pname,
                    enroll : parseInt(enroll),
                    linfo : linfo,
                    obj_method : obj_method
                })
                .then((res) => {
                    console.log(res);
                })
                .catch((error) => {console.log(error)});
                axios.post("http://localhost:9000/lecture/updateTime", {
                    lnum : lnum,
                    lt1_day : lt1_day,
                    lt1_time : parseInt(lt1_time),
                    lt2_day : lt2_day,
                    lt2_time : parseInt(lt2_time)
                })
                .then((res) => {
                    //정보수정 후 메인으로 이동
                    console.log(res);
                    alert("정보가 수정되었습니다.");
                    handleReset("ltime1_day");
                    handleReset("ltime2_day");
                    setType("view");
                    props.getLt("view");

                })
                .catch((error) => {console.log(error)});
            }
        }
    }

    const diffPage = () => {
        if(type === "search") {
            return (
                <Container>
                    <LnumLayer>학정번호: </LnumLayer>
                    <Lnum name="lnum" value={lnum} placeholder="학정번호 ('####-#-####-##' 꼴로 입력해주세요)"
                        onChange={onChange}
                        disabled={type==="view" ? true : false}
                    />
                    <NameLayer>교과목명: </NameLayer>
                    <Name name="name" value={name} placeholder="교과목명"
                        onChange={onChange} disabled={type==="view" ? true : false}
                    />
                    <Insert search onClick={onSearch}>{btn_name}</Insert>
                </Container>
            );
        }
        else if(type === "view" || type === "update") {
            const diffFunc = () => {
                if(type === "view") goUpdate();
                else onUpdate();
            }
            return (
                <Container>
                    <LnumLayer>학정번호: </LnumLayer>
                    <Lnum name="lnum" value={lnum} placeholder="학정번호 ('####-#-####-##' 꼴로 입력해주세요)"
                        onChange={onChange}
                        disabled={type==="view" ? true : false}
                    />
                    <NameLayer>교과목명: </NameLayer>
                    <Name name="name" value={name} placeholder="교과목명"
                        onChange={onChange} disabled={type==="view" ? true : false}
                    />
                    <ClassLayer>이수구분: </ClassLayer>
                    <Class name="classification" value={classification} onChange={onSelect} disabled={type==="view" ? true : false}>
                        <option value="none">=== 선 택 ===</option>
                        <option value="MR" key = "MR">전필</option>
                        <option value="MS" key = "MS">전선</option>
                        <option value="LR" key = "LR">교필</option>
                        <option value="LS" key = "LS">교선</option>
                        <option value="BR" key = "BR">기필</option>
                        <option value="BS" key = "BS">기선</option>
                    </Class>
                    <YearSemesterLayer>년도학기: </YearSemesterLayer>
                    <Year name="lyear" value={lyear} placeholder="년도" onChange={onChange} disabled={type==="view" ? true : false} />
                    <Semester name="lsemester" value={lsemester} placeholder="학기" onChange={onChange} disabled={type==="view" ? true : false} />
                    <ProfessorLayer>교수: </ProfessorLayer>
                    <PID name="pid" value={pid} placeholder="학번" onChange={onChange} disabled={type==="view" ? true : false} />
                    <Pname name="pname" value={pname} placeholder="이름" onChange={onChange} disabled={type==="view" ? true : false} />
                    <LtimeLayer>강의시간: </LtimeLayer>
                    <Ltime1_Day name="lt1_day" value={lt1_day} placeholder="요일1" onChange={onSelect} disabled={type==="view" ? true : false}>
                        <option value="x">== 선 택 ==</option>
                        <option value="mo">월</option>
                        <option value="tu">화</option>
                        <option value="we">수</option>
                        <option value="th">목</option>
                        <option value="fr">금</option>
                        <option value="sa">토</option>
                    </Ltime1_Day>
                    <Ltime1_Time name="lt1_time" value={lt1_time} placeholder="시간1" onChange={onSelect} ref={time1Ref} disabled>
                        <option value="">== 선 택 ==</option>
                        <option value="0">0교시</option>
                        <option value="1">1교시</option>
                        <option value="2">2교시</option>
                        <option value="3">3교시</option>
                        <option value="4">4교시</option>
                        <option value="5">5교시</option>
                        <option value="6">6교시</option>
                    </Ltime1_Time>
                    <Ltime2_Day name="lt2_day" value={lt2_day} placeholder="요일2" onChange={onSelect} disabled={type==="view" ? true : false}>
                        <option value="x">== 선 택 ==</option>
                        <option value="no">해당없음</option>
                        <option value="mo">월</option>
                        <option value="tu">화</option>
                        <option value="we">수</option>
                        <option value="th">목</option>
                        <option value="fr">금</option>
                        <option value="sa">토</option>
                    </Ltime2_Day>
                    <Ltime2_Time name="lt2_time" value={lt2_time} placeholder="시간2" onChange={onSelect} ref={time2Ref} disabled>
                        <option value="">== 선 택 ==</option>
                        <option value="0">0교시</option>
                        <option value="1">1교시</option>
                        <option value="2">2교시</option>
                        <option value="3">3교시</option>
                        <option value="4">4교시</option>
                        <option value="5">5교시</option>
                        <option value="6">6교시</option>
                    </Ltime2_Time>
                    <LroomLayer>강의실: </LroomLayer>
                    <Lroom name="lroom" value={lroom} placeholder="강의실" onChange={onChange} disabled={type==="view" ? true : false} />
                    <EnrollLayer>재적인원: </EnrollLayer>
                    <Enroll name="enroll" value={enroll} placeholder="재적인원" onChange={onChange} disabled={type==="view" ? true : false} />
                    <LinfoLayer>교과목개요: </LinfoLayer>
                    <Linfo name="linfo" value={linfo} placeholder="교과목개요" onChange={onChange} disabled={type==="view" ? true : false} />
                    <ObjMethodLayer>학습목표 및 학습방법: </ObjMethodLayer>
                    <ObjMethod name="obj_method" value={obj_method} placeholder="학습목표 및 학습방법" onChange={onChange} disabled={type==="view" ? true : false} />
                    <Insert onClick={diffFunc}>{btn_name}</Insert>
                    <p /><br />
                </Container>
            );
        }
    }

    return (
        <div>
            {diffPage()}
        </div>
    );
}

export default UpdateLInfo;