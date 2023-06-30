import React, {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';
import EachIDResult from './EachIDResult';

const Upper = styled.div`
    position: absolute; left:0px; top:0px;
    width:100%; height:40px;
    display:flex; align-items:center;
    padding: 11px 30px; border:0px;
    font-size:18px; font-weight:600;
    background: rgb(195,195,195,0.3);
`
const Close = styled.button`
    position: absolute; left:720px; top:10px;
    width:80px; height:40px;
    display:flex; justify-content:center; align-items:center;
    font-size:20px; font-weight:600;
    border:2px solid black; border-radius:5px;
`
const Caution = styled.div`
    position: absolute; top:50px;
    width:800px; height:100px; padding: 40px 20px;
    font-size:18px;
`
const SearchID = styled.div`
    position: absolute; top:200px; left:40px;
    width:720px; height:50px;
    border-top: 1px solid black; border-bottom: 1px solid black;
    display:flex; align-items:center;
`
const Name = styled.div`
    width:80px; height:50px;
    font-size:24px; font-weight:600;
    display:flex; justify-content: center; align-items:center;
    background: lightgray;
`
const NameDiv = styled.div`
    width:110px; height:50px;
    display:flex; justify-content: center; align-items:center;
`
const NameInput = styled.input`
    width:80px; height:30px;
    font-size:18px; padding: 0px 5px;
    border:1px solid black; border-radius:5px;
`
const DepDiv = styled.div`
    width:180px; height:50px;
    display:flex; justify-content: center; align-items:center;
`
const DepInput = styled.input`
    width:150px; height:30px;
    font-size:18px; padding: 0px 5px;
    border:1px solid black; border-radius:5px;
`
const Search = styled.button`
    width:50px; height:30px;
    font-size:16px; font-weight:600;
    border:2px solid black; border-radius:5px;
    background:rgb(25, 31, 52, 0.8); color:white;
`
const Info = styled.div`
    position: absolute; top:270px; left:40px;
    width:720px; height:200px;
    font-size:16px;
`
const Layer = styled.div`
    position: absolute; top:30px;
    width:100%; height:50px;
    border:1px solid gray; background: rgba(195,195,195,0.1);
    display:flex;
`
const Role = styled.div`
    width:120px; height:50px;
    font-size:16px; border-right:1px solid gray;
    display:flex; justify-content:center; align-items:center;
`
const Dep = styled.div`
    width:300px; height:50px;
    font-size:16px; border-right:1px solid gray;
    display:flex; justify-content:center; align-items:center;
`
const Sex = styled.div`
    width:120px; height:50px;
    font-size:16px; border-right:1px solid gray;
    display:flex; justify-content:center; align-items:center;
`
const Id = styled.div`
    width:280px; height:50px;
    font-size:16px;
    display:flex; justify-content:center; align-items:center;
`
const SearchResult1 = styled.div`
    position:absolute; top:80px;
    width:100%; height:50px; padding: 20px 0px;
    font-size:16px; border: 1px solid gray; border-top: 0px;
    display:flex; justify-content:center; text-align:center;
`
const SearchResult2 = styled.div`
    position:absolute; top:80px;
    width:100%; height:50px; padding:0px;
    display: grid; flex-direction: row;
`

export default function FindID (props) {
    const [data, setData] = useState([]);
    const [input, setInput] = useState({
        in_name: "", in_dep: ""
    });
    const {in_name, in_dep} = input;
    const onChange = (e) => {
        const {name, value} = e.target;
        setInput({
            ...input,
            [name]: value
        });
    }
    const onSearch = () => {
        axios
        .all([
            axios.get("http://localhost:9000/student/findByNameDep", {
                params: {name : in_name, dep : in_dep}
            }),
            axios.get("http://localhost:9000/professor/findByNameDep", {
                params: {name : in_name, dep : in_dep}
            })
        ])
        .then(
            axios.spread((res1, res2) => {
                const data1 = res1.data;
                const data2 = res2.data;
                const res = [];
                if(data1 !== "") res.push(data1);
                if(data2 !== "") res.push(data2);
                console.log(res);
                setData(res);
            })
        )
        .catch((error) => {console.log(error)});
        //검색 버튼 누르면 해당 정보 이용해서 정보 탐색해 data 리스트에 담을 수 있게 하기.
    }
    const EachResult = data.map((data) => (
        <EachIDResult role={data.user.role} dep={data.dep} sex={data.sex} id={data.user.id} />
    ));
    const diffResult = () => {
        if(data.length === 0) {
            return (
                <SearchResult1>
                    조회된 정보가 없습니다. <br />
                    이름과 주민등록번호가 정확히 입력되었는지 확인하시기 바랍니다.
                </SearchResult1>
            );
        }
        else {
            return (
                <SearchResult2>
                    {EachResult}<p />
                </SearchResult2>
            );
        }
    }

    return (
        <>
            <Upper>개인번호 조회</Upper>
            <Close onClick={() => {
                props.getModalIsOpen(false);
                props.getIDModal(false);
            }}>X 닫기</Close>
            <Caution>
                ※ 개인번호를 포함한 신분, 학과/부서, 성별 정보 조회 <br />
                &nbsp;&nbsp; - 이름과 학부를 모두 입력한 후 [검색] 버튼을 클릭하세요. <br />
                ※ 이름은 공백(space) 없이 입력하세요. <br />
                ※ 현재 재학 또는 휴학 중인 학생, 재직 중인 교수/직원, 출강 중인 외래강사만 검색됩니다.
            </Caution>
            <SearchID>
                <Name>이름</Name>
                <NameDiv>
                    <NameInput name="in_name" value={in_name} placeholder=" 이름" onChange={onChange} />
                </NameDiv>
                <Name>학부</Name>
                <DepDiv>
                    <DepInput name="in_dep" value={in_dep} placeholder=" 학부" onChange={onChange} />
                </DepDiv>
                <Search onClick={onSearch} >검색</Search>
                &nbsp;&nbsp;ex) 정지우 / 컴퓨터정보공학부
            </SearchID>
            <Info>
                개인번호 조회결과 <br />
                <Layer>
                    <Role>신 분</Role>
                    <Dep>학 부</Dep>
                    <Sex>성 별</Sex>
                    <Id>개인 번호</Id>
                </Layer>
                {diffResult()}
            </Info>
        </>
    );
}