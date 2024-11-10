import logo from './logo.svg';
import './App.css';
import React, { useEffect, useState } from 'react';

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("/springmvc-react-intg/api/ping")
      .then(response => response.text())
      .then(data => setMessage(data))
      .catch(error => console.error("Error fetching API:", error));
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <p>{message || "Loading..."}</p>
      </header>
    </div>
  );
}

export default App;
