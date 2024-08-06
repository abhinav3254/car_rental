import React from 'react';
import './App.css';
import Auth from './pages/Auth';
import { Home } from './pages/Home';
import { Route, Routes } from 'react-router-dom';

function App() {
  return (
    <div>
      <Routes>
        <Route path="/" element={<Auth />} />
        <Route path="/home" element={<Home />} />
      </Routes>

    </div>
  );
}

export default App;
