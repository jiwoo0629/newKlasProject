import React from 'react';
import styled from 'styled-components';

const Notice = styled.div`
    position:relative;
    width:1120px; height:40px;
    padding:10px 0px;
    display:flex; align-items:center;
    font-size:15px;
    border-bottom:1px solid gray;
`
const LInfo = styled.div`
    width:350px;
    font-size:16px; color:gray;
`
const NoticeTitle = styled.div`
    position:absolute; left:400px;
    width:720px;
    font-size:18px; font-weight:600;
`

export default function EachNotice (props) {
    return (
        <Notice>
            <LInfo>{props.data.date} {props.data.type} > <b style={{color:"black"}}>{props.data.name}</b></LInfo>
            <NoticeTitle>{props.data.title}</NoticeTitle>
        </Notice>
    );
}