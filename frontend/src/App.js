import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import AdminPage from './Pages/AdminPage';

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
                <Route path={`/admin`} element={<AdminPage />}></Route>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;
