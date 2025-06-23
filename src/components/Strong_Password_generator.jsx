import React, { useState } from "react";

export default function PasswordGenerator() {
  const [length, setLength] = useState(12);
  const [includeUpper, setIncludeUpper] = useState(true);
  const [includeLower, setIncludeLower] = useState(true);
  const [includeNumbers, setIncludeNumbers] = useState(true);
  const [includeSymbols, setIncludeSymbols] = useState(true);
  const [password, setPassword] = useState("");

  const generatePassword = () => {
    const upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const lower = "abcdefghijklmnopqrstuvwxyz";
    const numbers = "0123456789";
    const symbols = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    let characters = "";
    if (includeUpper) characters += upper;
    if (includeLower) characters += lower;
    if (includeNumbers) characters += numbers;
    if (includeSymbols) characters += symbols;

    if (characters === "") return setPassword("⚠️ Select at least one option");

    let newPassword = "";
    for (let i = 0; i < length; i++) {
      newPassword += characters[Math.floor(Math.random() * characters.length)];
    }
    setPassword(newPassword);
  };

  const copyToClipboard = () => {
    navigator.clipboard.writeText(password);
    alert("Password copied to clipboard!");
  };

  return (
    <div style={styles.container}>
      <h2>🔐 Strong Password Generator</h2>

      <div style={styles.row}>
        <label>Password Length: </label>
        <input
          type="number"
          min="4"
          max="64"
          value={length}
          onChange={(e) => setLength(e.target.value)}
          style={styles.input}
        />
      </div>

      <div style={styles.checkboxRow}>
        <label>
          <input
            type="checkbox"
            checked={includeUpper}
            onChange={() => setIncludeUpper(!includeUpper)}
          />
          Uppercase
        </label>
        <label>
          <input
            type="checkbox"
            checked={includeLower}
            onChange={() => setIncludeLower(!includeLower)}
          />
          Lowercase
        </label>
        <label>
          <input
            type="checkbox"
            checked={includeNumbers}
            onChange={() => setIncludeNumbers(!includeNumbers)}
          />
          Numbers
        </label>
        <label>
          <input
            type="checkbox"
            checked={includeSymbols}
            onChange={() => setIncludeSymbols(!includeSymbols)}
          />
          Symbols
        </label>
      </div>

      <button onClick={generatePassword} style={styles.button}>
        Generate Password
      </button>

      <div style={styles.passwordBox}>
        <input
          type="text"
          value={password}
          readOnly
          style={styles.passwordInput}
        />
        <button onClick={copyToClipboard} style={styles.copyButton}>
          Copy
        </button>
      </div>
    </div>
  );
}

const styles = {
  container: {
    background: "#fff",
    padding: "2rem",
    borderRadius: "12px",
    maxWidth: "400px",
    margin: "2rem auto",
    textAlign: "center",
    boxShadow: "0 0 12px rgba(0,0,0,0.1)",
    fontFamily: "sans-serif",
  },
  row: {
    marginBottom: "1rem",
  },
  checkboxRow: {
    display: "flex",
    justifyContent: "space-between",
    flexWrap: "wrap",
    gap: "0.5rem",
    marginBottom: "1rem",
  },
  input: {
    padding: "0.3rem",
    width: "60px",
    textAlign: "center",
    marginLeft: "1rem",
  },
  button: {
    padding: "0.5rem 1rem",
    backgroundColor: "#007bff",
    color: "#fff",
    border: "none",
    borderRadius: "8px",
    cursor: "pointer",
    marginBottom: "1rem",
  },
  passwordBox: {
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
    gap: "0.5rem",
  },
  passwordInput: {
    flex: 1,
    padding: "0.5rem",
    fontSize: "1rem",
    border: "1px solid #ccc",
    borderRadius: "6px",
  },
  copyButton: {
    padding: "0.5rem",
    backgroundColor: "#28a745",
    color: "#fff",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer",
  },
};
export { PasswordGenerator };