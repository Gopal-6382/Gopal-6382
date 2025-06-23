import React, { useState, useMemo } from "react";
import dayjs from "dayjs";
import "bootstrap/dist/css/bootstrap.min.css";

// Sample events
const sampleEvents = {
  "2025-06-24": [{ title: "Doctor Appointment" }],
  "2025-06-28": [{ title: "Team Meeting" }],
};

const App = () => {
  const today = dayjs();
  const [currentMonth, setCurrentMonth] = useState(today.startOf("month"));
  const [events, setEvents] = useState(sampleEvents);

  // Get all days for current month view (including previous/next month overflow)
  const daysInMonth = useMemo(() => {
    const start = currentMonth.startOf("week");
    const end = currentMonth.endOf("month").endOf("week");
    const dates = [];
    let day = start;

    while (day.isBefore(end) || day.isSame(end)) {
      dates.push(day);
      day = day.add(1, "day");
    }

    return dates;
  }, [currentMonth]);

  const isToday = (date) => dayjs().isSame(date, "day");

  const handlePrevMonth = () =>
    setCurrentMonth((prev) => prev.subtract(1, "month"));
  const handleNextMonth = () => setCurrentMonth((prev) => prev.add(1, "month"));

  const formatDate = (date) => date.format("YYYY-MM-DD");

  const handleAddEvent = (dateStr) => {
    const title = prompt("Enter event title:");
    if (title) {
      setEvents((prev) => ({
        ...prev,
        [dateStr]: [...(prev[dateStr] || []), { title }],
      }));
    }
  };

  return (
    <div className="container-fluid p-4 bg-light min-vh-100">
      <div className="text-center mb-4">
        <h1 className="fw-bold">{currentMonth.format("MMMM YYYY")}</h1>
        <div className="d-flex justify-content-center gap-2 mt-2">
          <button className="btn btn-outline-primary" onClick={handlePrevMonth}>
            &laquo; Prev
          </button>
          <button className="btn btn-outline-primary" onClick={handleNextMonth}>
            Next &raquo;
          </button>
        </div>
      </div>

      {/* Weekdays Header */}
      <div className="row text-center fw-bold border-bottom pb-2">
        {["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"].map((d) => (
          <div className="col border-end" key={d}>
            {d}
          </div>
        ))}
      </div>

      {/* Calendar Days */}
      <div className="row">
        {daysInMonth.map((date, idx) => {
          const dateStr = formatDate(date);
          const isCurrMonth = date.month() === currentMonth.month();
          const cellEvents = events[dateStr] || [];

          return (
            <div
              key={idx}
              className="col border p-2 position-relative"
              style={{
                height: "120px",
                backgroundColor: isToday(date)
                  ? "#e9f5ff"
                  : isCurrMonth
                  ? "white"
                  : "#f8f9fa",
                color: isCurrMonth ? "black" : "#bbb",
                cursor: "pointer",
              }}
              onClick={() => handleAddEvent(dateStr)}
            >
              <div className="fw-bold small">{date.date()}</div>

              {cellEvents.map((e, i) => (
                <div
                  key={i}
                  className="badge bg-primary text-white mt-1 text-wrap"
                  style={{ fontSize: "0.7rem" }}
                >
                  {e.title}
                </div>
              ))}
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default App;
