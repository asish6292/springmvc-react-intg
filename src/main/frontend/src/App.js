import './App.css';
import React, { useEffect, useState } from "react";
import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import { fetchData } from './api';

// Sample Components
const Home = () => <h2>Home Page</h2>;
const About = () => <h2>About Page</h2>;
const NotFound = () => <h2>404 - Page Not Found</h2>;

const logo = `${process.env.PUBLIC_URL}/images/bird.jpg`;

const App = () => {
  const [message, setMessage] = useState("");

  useEffect(() => {
    const getData = async () => {
      try {
        const result = await fetchData("/api/ping");
        setMessage(result);
      } catch (error) {
        console.error("Failed to fetch data:", error);
      }
    };
    
    getData();
  }, []);
  return (
    <Router basename={process.env.PUBLIC_URL || "/"}>
      <div>
        <h1>My React App</h1>
        <div>Api val {message}</div>
        <img src={logo} alt="Logo" height={"50px"} width={"50px"}/>
        <nav>
          <ul>
            <li><a href="/springmvc-react-intg/">Home</a></li>
            <li><a href="/springmvc-react-intg/about">About</a></li>
          </ul>
        </nav>

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
