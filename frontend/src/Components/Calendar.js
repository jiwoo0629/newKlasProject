import React, { useState } from "react";
import styled from 'styled-components';
import { getYear, getMonth } from "date-fns"; // getYear, getMonth
import DatePicker, { registerLocale } from "react-datepicker";  // 한국어적용
import 'react-datepicker/dist/react-datepicker.css';
import ko from 'date-fns/locale/ko'; // 한국어적용

registerLocale("ko", ko) // 한국어적용
const _ = require('lodash');

const NewDatePicker = styled(DatePicker)`
    display:flex; justify-content:center;
    box-sizing:border-box; width: 200px;
    border: 1px solid gray; border-radius: 4px;
    font-size:16px; padding: 8px 2px;
`

function Calendar (props) {
    const [startDate, setStartDate] = useState(new Date());
    const years = _.range(1950, getYear(new Date()) + 1, 1); // 수정
    const months = ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'];
    const dateFormat = "yyyy년 MM월 dd일"
      return (
        <NewDatePicker
          renderCustomHeader={({
            date,
            changeYear,
            changeMonth,
            decreaseMonth,
            increaseMonth,
            prevMonthButtonDisabled,
            nextMonthButtonDisabled
          }) => (
            <div>
              <button onClick={decreaseMonth} disabled={prevMonthButtonDisabled}>
                {"<"}
              </button>
              <select
                value={getYear(date)}
                onChange={({ target: { value } }) => changeYear(value)}
              >
                {years.map(option => (
                  <option key={option} value={option}>
                    {option}
                  </option>
                ))}
              </select>
              <select
                value={months[getMonth(date)]}
                onChange={({ target: { value } }) =>
                  changeMonth(months.indexOf(value))
                }
              >
                {months.map(option => (
                  <option key={option} value={option}>
                    {option}
                  </option>
                ))}
              </select>
              <button onClick={increaseMonth} disabled={nextMonthButtonDisabled}>
                {">"}
              </button>
            </div>
          )}
            selected={startDate}
            dateFormat={dateFormat}
            locale={ko}
            onChange={
                date => {
                    setStartDate(date)
                    props.getBirth(date);
                }
            }
        />
      );
};

export default Calendar;