import { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

export const Table = () => {
  const [user, setUser] = useState({
    name: "ram",
    age: 21,
    isMarried: false,
    hobbies: ["reading", "gaming", "coding"],
    country: "India",
  });

  const [hobbyState, setHobbyState] = useState({
    reading: true,
    gaming: true,
    coding: true,
  });

  const handleInputChange = (e) => {
    const { name, type, value, checked } = e.target;
    const newValue = type === "checkbox" ? checked : value;
    setUser((prev) => ({ ...prev, [name]: newValue }));

    if (name in hobbyState) {
      const updatedHobbyState = { ...hobbyState, [name]: newValue };
      setHobbyState(updatedHobbyState);

      const selectedHobbies = Object.entries(updatedHobbyState)
        .filter(([_, isChecked]) => isChecked)
        .map(([hobby]) => hobby);

      setUser((prev) => ({ ...prev, hobbies: selectedHobbies }));
    } else {
      setUser((prev) => ({
        ...prev,
        [name]: type === "radio" ? value === "true" : newValue,
      }));
    }
  };

  return (
    <div className="container mt-4">
      <h4 className="mb-3">User Info</h4>
      <table className="table table-bordered table-striped">
        <tbody>
          <tr>
            <th>ID</th>
            <td>1</td>
          </tr>
          <tr>
            <th>Name</th>
            <td>{user.name}</td>
          </tr>
          <tr>
            <th>Age</th>
            <td>{user.age}</td>
          </tr>
          <tr>
            <th>Married</th>
            <td>{user.isMarried ? "Yes" : "No"}</td>
          </tr>
          <tr>
            <th>Hobbies</th>
            <td>{user.hobbies.join(", ")}</td>
          </tr>
          <tr>
            <th>Country</th>
            <td>{user.country}</td>
          </tr>
        </tbody>
      </table>

      <h5 className="mt-4">Update Info</h5>

      <form className="mt-3">
        <div className="mb-3">
          <label htmlFor="nameInput" className="form-label">
            Change Name
          </label>
          <input
            type="text"
            className="form-control"
            id="nameInput"
            name="name"
            value={user.name}
            onChange={handleInputChange}
          />
        </div>

        <div className="mb-3">
          <label htmlFor="ageInput" className="form-label">
            Change Age
          </label>
          <input
            type="number"
            className="form-control"
            id="ageInput"
            name="age"
            value={user.age}
            onChange={handleInputChange}
          />
        </div>

        <div className="mb-3">
          <label className="form-label d-block">Marital Status</label>
          <div className="form-check form-check-inline">
            <input
              type="radio"
              name="isMarried"
              value="true"
              id="marriedYes"
              className="form-check-input"
              checked={user.isMarried === true}
              onChange={handleInputChange}
            />
            <label className="form-check-label" htmlFor="marriedYes">
              Married
            </label>
          </div>
          <div className="form-check form-check-inline">
            <input
              type="radio"
              name="isMarried"
              value="false"
              id="marriedNo"
              className="form-check-input"
              checked={user.isMarried === false}
              onChange={handleInputChange}
            />
            <label className="form-check-label" htmlFor="marriedNo">
              Not Married
            </label>
          </div>
        </div>

        <div className="mb-3">
          <label className="form-label d-block">Hobbies</label>
          {["reading", "gaming", "coding"].map((hobby) => (
            <div className="form-check form-check-inline" key={hobby}>
              <input
                type="checkbox"
                className="form-check-input"
                id={`hobby-${hobby}`}
                name={hobby}
                checked={hobbyState[hobby]}
                onChange={handleInputChange}
              />
              <label className="form-check-label" htmlFor={`hobby-${hobby}`}>
                {hobby.charAt(0).toUpperCase() + hobby.slice(1)}
              </label>
            </div>
          ))}
        </div>

        <div className="mb-3">
          <label htmlFor="country" className="form-label">
            Select Country
          </label>
          <select
            id="country"
            name="country"
            className="form-select"
            value={user.country}
            onChange={handleInputChange}
          >
            <option value="India">India</option>
            <option value="USA">USA</option>
            <option value="Germany">Germany</option>
            <option value="Japan">Japan</option>
          </select>
        </div>
      </form>
    </div>
  );
};
