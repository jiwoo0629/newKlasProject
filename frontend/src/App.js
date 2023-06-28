import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminPage from './Pages/AdminPage';
import LoginPage from './Pages/LoginPage';

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path={`/`} element={<LoginPage />}></Route>
                <Route path={`/admin`} element={<AdminPage />}></Route>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
