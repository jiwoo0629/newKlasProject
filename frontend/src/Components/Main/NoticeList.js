import React from 'react';
import styled from 'styled-components';
import EachNotice from './EachNotice';

const NoticeLayer = styled.div`
    position:absolute;
    width:95%; height:40px;
    font-size:24px; color:black;
    border-bottom:1px solid gray;
`
const ListContainer = styled.div`
    position:relative; top:40px;
`

export default function NoticeList (props) {
    const noticeList = props.Notice.map((data) => (
        <EachNotice data={data} />
    ));
    return (
        <>
            <NoticeLayer><b>과목별</b> <b style={{color:"brown"}}>NOTICE</b></NoticeLayer>
            <ListContainer>
                {noticeList}<p />
            </ListContainer>
        </>
    );
}