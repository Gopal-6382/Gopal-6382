import React, { useEffect, useState } from "react";
import axios from "axios";

export default function CurrencyConverter() {
  const [currencies, setCurrencies] = useState([]);
  const [fromCurrency, setFromCurrency] = useState("USD");
  const [toCurrency, setToCurrency] = useState("INR");
  const [amount, setAmount] = useState(1);
  const [converted, setConverted] = useState(null);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  // Fetch available currencies once
  useEffect(() => {
    const fetchCurrencies = async () => {
      try {
        const res = await axios.get("https://api.exchangerate-api.com/v4/latest/USD");
        setCurrencies(Object.keys(res.data.rates));
      } catch (err) {
        console.error("Currency list fetch error:", err);
        setError("Failed to load currency list.");
      }
    };
    fetchCurrencies();
  }, []);

  // Convert currency whenever inputs change (with debounce)
  useEffect(() => {
    if (!fromCurrency || !toCurrency || !amount) return;

    const delay = setTimeout(() => {
      convertCurrency();
    }, 500); // debounce delay

    return () => clearTimeout(delay);
  }, [fromCurrency, toCurrency, amount]);

  const convertCurrency = async () => {
    setError("");
    setLoading(true);
    try {
      const res = await axios.get(
        `https://api.exchangerate-api.com/v4/latest/${fromCurrency}`
      );
      const rate = res.data.rates[toCurrency];
      if (!rate) {
        throw new Error("Invalid conversion rate.");
      }
      setConverted((amount * rate).toFixed(2));
    } catch (err) {
      console.error("Conversion error:", err);
      setError("Currency conversion failed.");
      setConverted(null);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container mt-5">
      <div className="card shadow-lg p-4 rounded-4">
        <h3 className="text-center mb-3">🌍 Currency Converter</h3>

        <hr style={{ borderTop: "2px dotted #bbb" }} />

        <div className="row g-3">
          <div className="col-md-6">
            <label className="form-label">From</label>
            <select
              className="form-select"
              value={fromCurrency}
              onChange={(e) => setFromCurrency(e.target.value)}
            >
              {currencies.map((cur) => (
                <option key={cur}>{cur}</option>
              ))}
            </select>
          </div>
          <div className="col-md-6">
            <label className="form-label">To</label>
            <select
              className="form-select"
              value={toCurrency}
              onChange={(e) => setToCurrency(e.target.value)}
            >
              {currencies.map((cur) => (
                <option key={cur}>{cur}</option>
              ))}
            </select>
          </div>
        </div>

        <hr style={{ borderTop: "2px dotted #bbb" }} className="my-4" />

        <div className="mb-3">
          <label className="form-label">Amount</label>
          <input
            type="number"
            className="form-control"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
            min="0"
          />
        </div>

        <div className="d-grid">
          <button
            className="btn btn-primary"
            onClick={convertCurrency}
            disabled={loading}
          >
            {loading ? "Converting..." : "Convert Now"}
          </button>
        </div>

        {error && <div className="alert alert-danger mt-3">{error}</div>}

        {converted && !error && (
          <div className="mt-4 alert alert-success text-center">
            💰 Converted Amount:{" "}
            <strong>
              {toCurrency} - VALUE IS - {converted}
            </strong>
          </div>
        )}
      </div>
    </div>
  );
}
