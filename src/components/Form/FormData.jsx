import { useState } from "react";

export const FormData = () => {
  const [user, setUser] = useState({
    name: "ram",
    age: 21,
  });

  function changeName(e) {
    setUser((prev) => ({
      ...prev,
      name: e.target.value,
    }));
  }

  function changeAge(e) {
    setUser((prev) => ({
      ...prev,
      age: Number(e.target.value), // Convert age to number
    }));
  }

  return (
    <div style={{ padding: "1rem", fontFamily: "Arial" }}>
      <h2>Form Data Example</h2>

      <label>
        Name:
        <input
          type="text"
          value={user.name}
          onChange={changeName}
          style={{ marginLeft: "10px" }}
        />
      </label>
      <br />
      <br />

      <label>
        Age:
        <input
          type="number"
          value={user.age}
          onChange={changeAge}
          style={{ marginLeft: "10px" }}
        />
      </label>
      <br />
      <br />

      <h3>Live Preview:</h3>
      <p>
        <strong>Name:</strong> {user.name}
      </p>
      <p>
        <strong>Age:</strong> {user.age}
      </p>
    </div>
  );
};

export const FormData1 = () => {
  const [user, setUser] = useState({
    fname: "ram",
    age: 21,
    lname: "sharma",
  });

  // Update a specific field dynamically based on input's name attribute
  function handleChange(uservalue) {
    const { name, value } = uservalue.target; // get name and value from input
    setUser((usestateobj) => ({
      ...usestateobj,
      [name]: name === "age" ? Number(value) : value, // convert age to number if needed
    }));
    console.log(uservalue.target);
  }

  return (
    <div style={{ padding: "1rem", fontFamily: "Arial" }}>
      <h2>Form Data Example</h2>

      <label>
        First Name:
        <input
          type="text"
          name="fname"
          value={user.fname}
          onChange={handleChange}
          style={{ marginLeft: "10px" }}
        />
      </label>
      <br />
      <br />

      <label>
        Last Name:
        <input
          type="text"
          name="lname"
          value={user.lname}
          onChange={handleChange}
          style={{ marginLeft: "10px" }}
        />
      </label>
      <br />
      <br />

      <label>
        Age:
        <input
          type="number"
          name="age"
          value={user.age}
          onChange={handleChange}
          style={{ marginLeft: "10px" }}
        />
      </label>
      <br />
      <br />

      <h3>Live Preview:</h3>
      <p>
        <strong>First Name:</strong> {user.fname}
      </p>
      <p>
        <strong>Last Name:</strong> {user.lname}
      </p>
      <p>
        <strong>Age:</strong> {user.age}
      </p>
    </div>
  );
};
