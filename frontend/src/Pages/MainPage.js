import React, {useState} from 'react';
import styled from 'styled-components';
import axios from 'axios';
import UpperLayer from '../Components/Main/UpperLayer';

const Container = styled.div`
    width:100%; height:100%;
    background: rgba(153, 153, 153, 0.1);
`

export default function MainPage () {
    return (
        <Container>
            <UpperLayer />
        </Container>
    );
}