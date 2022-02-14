import React from "react";
import { Link } from "react-router-dom";

export default function Menu() {
    return (
        <nav className="menu">
            <Link to="/">Home</Link>
            <Link to="/Destinos">Destinos</Link>
            <Link to="/Adm">Adm</Link>
        </nav>
    );
}