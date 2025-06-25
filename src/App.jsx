import React from "react";
import DigitalClock from "./components/Cloack";
import { PasswordGenerator } from "./components/Strong_Password_generator";
// import Calendar from "./components/calander.jsx";
import AxiosDemo from "./components/axios.jsx";
import Question from "./components/question.jsx";
import UserListApp from "./components/usemom.jsx";
import Calendar from "./components/calander/calander2.jsx";
export default function App() {
  return (
    <>
      {/* <div style={styles.container}>
      <h1 style={styles.heading}>React Digital Clock</h1>
      <DigitalClock />
    </div> */}
      {/* <Calendar /> */}
      {/* <UserListApp /> */}
      {/* <AxiosDemo/> */}
      {/* <PasswordGenerator /> */}
      {/* <Question/> */}
      <Calendar/>
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
