import React from 'react';
import './App.css';
import Auth from './pages/Auth';
import { Home } from './pages/Home';
import { Route, Routes } from 'react-router-dom';
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function App() {

  axios.defaults.baseURL = 'http://localhost:8080/'
  axios.defaults.withCredentials = true;

  return (
    <div>
      <ToastContainer />
      <Routes>
        <Route path="/" element={<Auth />} />
        <Route path="/home" element={<Home />} />
      </Routes>

    </div>
  );
}

export default App;
