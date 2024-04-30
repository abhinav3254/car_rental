import { Route, Routes } from "react-router-dom";
import Auth from "./components/Auth";
import axios from "axios";
import Home from "./components/Home";

export default function App() {
  axios.defaults.baseURL = 'http://localhost:8080/';
  return (
    <div>
      <Routes>
        <Route path="/" element={<Auth />} />
        <Route path="/home" element={<Home />} />
      </Routes>
    </div>
  )
}