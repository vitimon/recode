import { BrowserRouter, Routes, Route } from "react-router-dom";

import Home from "./views/Home";
import Destinos from "./views/Destinos";
import Adm from "./views/Adm";
import Menu from "./components/Menu";
import Contents from "./components/Contents";

import "./assets/css/style.css";


import axios from 'axios';

const api = {
    baseUrl = "localhost:8080"
}
function App() {
    return (
        <BrowserRouter>
            <Menu />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/Destinos" element={<Destinos />} />
                <Route path="/Adm" element={<Adm />} />

            </Routes>
        </BrowserRouter>
    );
}

export default App;