"use client"

import React from "react"
import Input from "@/Input/Input";

import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom";
import Home from "./Home";
const Navbar = () => {

    return (
      
            <Router>
                <ul>

                    <li>
                        <Link to="/Home" className= "nav-link">Home</Link>

                    </li>
                    <li>
                        <Link to="/Input" className="nav-link">ADD Student</Link>
                    </li>
                </ul>
                <Routes>

                    <Route path="/Home" element={<Home />}></Route>
                    <Route path="/Input" element={<Input />}></Route>
                 

                </Routes>


            </Router>
     
    )
}

export default Navbar