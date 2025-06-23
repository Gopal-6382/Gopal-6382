import React from "react";
import ReactDOM from "react-dom/client"; // ✅ use 'react-dom/client' for React 18+
import App from "./App.jsx";
import "bootstrap/dist/css/bootstrap.min.css"; // ✅ load Bootstrap

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
