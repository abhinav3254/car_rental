import { Route, Routes } from "react-router-dom";
import Auth from "./components/Auth";
import axios from "axios";
import Home from "./components/Home";
import Nav from "./components/Nav";
import Profile from "./components/Profile";
import VehicleType from "./components/VehicleType";

export default function App() {
  axios.defaults.baseURL = 'http://localhost:8080/';
  return (
    <div>
      <Nav />
      <div className="pt-[80px]">
        <Routes>
          <Route path="/" element={<Auth />} />
          <Route path="/home" element={<Home />} />
          <Route path="/profile" element={<Profile />} />
          <Route path="/admin/vehicle-type" element={<VehicleType />} />
        </Routes>
      </div>
    </div>
  )
}