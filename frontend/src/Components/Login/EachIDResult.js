import React from 'react';
import styled from 'styled-components';

const Layer = styled.div`
    width:720px; height:50px;
    border:1px solid gray; display:flex;
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

export default function EachIDResult (props) {
    const role = (props.role === "stu") ? "학생" : "교수";
    const sex = (props.sex === "M") ? "남" : "여";
    return (
        <Layer>
            <Role>{role}</Role>
            <Dep>{props.dep}</Dep>
            <Sex>{sex}</Sex>
            <Id>{props.id}</Id>
        </Layer>
    );
}