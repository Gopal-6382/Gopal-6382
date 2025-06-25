import React, { useState, useMemo } from "react";

// 🧠 Memoized user list item
const UserItem = React.memo(({ user }) => {
  console.log("Rendering:", user.name);
  return <li>{user.name}</li>;
});

const UserListApp = () => {
  const [filter, setFilter] = useState("");

  const users = useMemo(() => [
    { id: 1, name: "Alice" },
    { id: 2, name: "Bob" },
    { id: 3, name: "Charlie" },
    { id: 4, name: "David" },
  ], []);

  // 🧠 useMemo to avoid recalculating filtered users unless `filter` or `users` change
  const filteredUsers = useMemo(() => {
    console.log("Filtering users...");
    return users.filter((user) =>
      user.name.toLowerCase().includes(filter.toLowerCase())
    );
  }, [filter, users]);

  return (
    <div>
      <h1>User List</h1>
      <input
        type="text"
        placeholder="Search users..."
        value={filter}
        onChange={(e) => setFilter(e.target.value)}
      />

      <ul>
        {filteredUsers.map((user) => (
          <UserItem key={user.id} user={user} />
        ))}
      </ul>
    </div>
  );
};

export default UserListApp;
