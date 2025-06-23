import React from "react";
import DigitalClock from "./components/Cloack";
import {PasswordGenerator} from "./components/Strong_Password_generator";
export default function App() {
  return (
    <>
      {/* <div style={styles.container}>
      <h1 style={styles.heading}>React Digital Clock</h1>
      <DigitalClock />
    </div> */}

    <PasswordGenerator />

    </>
  );
}

// Styles
// const styles = {
//   container: {
//     textAlign: "center",
//     padding: "3rem",
//     backgroundColor: "#f0f0f0",
//     height: "100vh",
//     fontFamily: "Arial, sans-serif",
//   },
//   heading: {
//     marginBottom: "2rem",
//   },
// };
