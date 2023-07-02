import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminPage from './Pages/AdminPage';
import LoginPage from './Pages/LoginPage';
import MainPage from './Pages/MainPage';
import MyInfoPage from './Pages/MyInfoPage';
import Modal from 'react-modal';

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path={`/`} element={<LoginPage />}></Route>
                <Route path={`/main`} element={<MainPage />}></Route>
                <Route path={`/main/myInfo`} element={<MyInfoPage />}></Route>
                <Route path={`/admin`} element={<AdminPage />}></Route>
            </Routes>
        </BrowserRouter>
    </div>
  );
}
Modal.setAppElement('#root')

export default App;
