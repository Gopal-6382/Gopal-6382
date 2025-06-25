import React, { useState } from "react";
import "./calander.scss";

// Weekday and month names for labels
const daysOfWeek = ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"];
const months = [
  "January", "February", "March", "April", "May", "June",
  "July", "August", "September", "October", "November", "December"
];

export default function Calendar() {
  const [selectedDate, setSelectedDate] = useState(new Date());

  // 🔍 Check if a date is today
  const isToday = (date) => {
    const today = new Date();
    const result =
      date.getDate() === today.getDate() &&
      date.getMonth() === today.getMonth() &&
      date.getFullYear() === today.getFullYear();

    console.log("🔎 isToday check:", {
      checking: date.toDateString(),
      today: today.toDateString(),
      isToday: result,
    });
    return result;
  };

  // 📅 Generate the days to display in the calendar view
  const getDaysInCalendar = () => {
    const year = selectedDate.getFullYear();
    const month = selectedDate.getMonth();

    const firstDayOfMonth = new Date(year, month, 1);         // e.g. June 1
    const lastDayOfMonth = new Date(year, month + 1, 0);       // e.g. June 30

    const days = [];

    // ➕ Add previous month's trailing days to fill the first row
    const prevMonthLastDate = new Date(year, month, 0).getDate();
    const firstWeekday = firstDayOfMonth.getDay();

    console.log("📆 Month:", months[month], year);
    console.log("📆 First day of month:", firstDayOfMonth.toDateString(), "(weekday index:", firstWeekday, ")");
    console.log("📆 Last day of month:", lastDayOfMonth.toDateString());

    for (let i = firstWeekday - 1; i >= 0; i--) {
      const prevDate = new Date(year, month - 1, prevMonthLastDate - i);
      days.push({ date: prevDate, currentMonth: false });
      console.log("⬅️ Previous month day added:", prevDate.toDateString());
    }

    // ➕ Add current month's days
    for (let i = 1; i <= lastDayOfMonth.getDate(); i++) {
      const current = new Date(year, month, i);
      days.push({ date: current, currentMonth: true });
      console.log("✅ Current month day added:", current.toDateString());
    }

    // ➕ Add next month's leading days to complete the last row
    const remaining = (7 - (days.length % 7)) % 7;
    console.log("➡️ Next month days to fill grid:", remaining);

    for (let i = 1; i <= remaining; i++) {
      const nextDate = new Date(year, month + 1, i);
      days.push({ date: nextDate, currentMonth: false });
      console.log("➡️ Next month day added:", nextDate.toDateString());
    }

    console.table(days.map((d) => ({
      date: d.date.toDateString(),
      currentMonth: d.currentMonth
    })));

    return days;
  };

  // 🔄 Change the currently displayed month (offset can be -1 or 1)
  const changeMonth = (offset) => {
    const newDate = new Date(selectedDate);
    newDate.setMonth(newDate.getMonth() + offset);
    console.log(`🔁 Month changed by ${offset}:`, newDate.toDateString());
    setSelectedDate(newDate);
  };

  // 📆 Build a dropdown of years for selection
  const yearRange = Array.from({ length: 10 }, (_, i) => selectedDate.getFullYear() - 5 + i);

  console.log("📅 Rendering calendar for:", selectedDate.toDateString());

  return (
    <div className="calendar">
      {/* Header with month/year selectors */}
      <div className="header">
        <button onClick={() => changeMonth(-1)}>&lt;</button>

        <div>
          {/* Month Dropdown */}
          <select
            value={selectedDate.getMonth()}
            onChange={(e) => {
              const newMonth = parseInt(e.target.value);
              const newDate = new Date(selectedDate);
              newDate.setMonth(newMonth);
              console.log("📌 Month selected:", months[newMonth]);
              setSelectedDate(newDate);
            }}
          >
            {months.map((month, idx) => (
              <option key={idx} value={idx}>
                {month}
              </option>
            ))}
          </select>

          {/* Year Dropdown */}
          <select
            value={selectedDate.getFullYear()}
            onChange={(e) => {
              const newYear = parseInt(e.target.value);
              const newDate = new Date(selectedDate);
              newDate.setFullYear(newYear);
              console.log("📌 Year selected:", newYear);
              setSelectedDate(newDate);
            }}
          >
            {yearRange.map((year) => (
              <option key={year} value={year}>
                {year}
              </option>
            ))}
          </select>
        </div>

        <button onClick={() => changeMonth(1)}>&gt;</button>
      </div>

      {/* Day Labels */}
      <div className="daysOfWeek">
        {daysOfWeek.map((day) => (
          <div key={day}>{day}</div>
        ))}
      </div>

      {/* Calendar Days */}
      <div className="days">
        {getDaysInCalendar().map((item, id) => (
          <div
            key={id}
            className={
              item.currentMonth
                ? isToday(item.date)
                  ? "day today"
                  : "day"
                : "empty"
            }
          >
            {item.date.getDate()}
          </div>
        ))}
      </div>
    </div>
  );
}
