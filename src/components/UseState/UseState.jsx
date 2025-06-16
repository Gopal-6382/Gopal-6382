import { useState } from 'react';

export const UseState = () => {
  const [user, setUser] = useState({ name: "Ram", age: 22 });

  const changeName = () => {
    setUser(prev => ({ ...prev, name: "Shyam" }));
  };

  const increaseAge = () => {
    setUser(prev => ({ ...prev, age: prev.age + 1 }));
  };

  const resetUser = () => {
    setUser({ name: "Ram", age: 22 });
  };

  return (
    <>
      <h1>useState Example</h1>
      <h2>User Info</h2>
      <p><strong>Name:</strong> {user.name}</p>
      <p><strong>Age:</strong> {user.age}</p>

      <button onClick={changeName}>Change Name</button>
      <button onClick={increaseAge} style={{ marginLeft: "10px" }}>Increase Age</button>
      <button onClick={resetUser} style={{ marginLeft: "10px" }}>Reset</button>
    </>
  );
};
