import React, {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';

const Close = styled.button`
    position: absolute; left:720px; top:10px;
    width:80px; height:40px;
    display:flex; justify-content:center; align-items:center;
    font-size:20px; font-weight:600;
    border:2px solid black; border-radius:5px;
`

export default function ChangePW (props) {
    return (
        <>
            <Close onClick={() => {
                props.getModalIsOpen(false);
                props.getChangePWModal(false);
            }}>X 닫기</Close>
        </>
    );
}