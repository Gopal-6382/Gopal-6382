import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App.jsx';             // Make sure App.jsx exists in src
import './index.css';                   // Ensure index.css exists in src
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/main.css';                // Ensure main.css exists in src/css
import 'bootstrap-icons/font/bootstrap-icons.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
