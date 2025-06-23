import React, { useEffect, useState } from "react";

export default function DigitalClock() {
  const [time, setTime] = useState(new Date());
  const [date, setDate] = useState(new Date());

  useEffect(() => {
    const id = setInterval(() => {
      const now = new Date();
      setTime(now);

      if (
        now.getHours() === 0 &&
        now.getMinutes() === 0 &&
        now.getSeconds() === 0
      ) {
        setDate(now);
      }
    }, 1000);

    return () => clearInterval(id);
  }, []);

  const formatTime = (date) =>
    date.toLocaleTimeString("en-US", { hour12: false });

  const formatDate = (date) =>
    date.toLocaleDateString("en-US", {
      weekday: "short",
      month: "short",
      day: "numeric",
      year: "numeric",
    });

  return (
    <div style={styles.clockContainer}>
      <div style={styles.time}>🕒 {formatTime(time)}</div>
      <div style={styles.date}>📅 {formatDate(date)}</div>
    </div>
  );
}

// Styles
const styles = {
  clockContainer: {
    backgroundColor: "#222",
    color: "#0f0",
    padding: "1.5rem 3rem",
    borderRadius: "12px",
    display: "inline-block",
    fontFamily: "monospace",
    boxShadow: "0 4px 12px rgba(0,0,0,0.2)",
  },
  time: {
    fontSize: "3rem",
    marginBottom: "0.5rem",
  },
  date: {
    fontSize: "1.5rem",
    color: "#0c0",
  },
};
