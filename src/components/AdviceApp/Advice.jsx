import { useState, useEffect, useRef } from "react";
// import "../../sass/advice.scss";

export const Advice = () => {
  const [adviceData, setAdviceData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [count, setCount] = useState(0);
  const hasFetched = useRef(false); // prevent double fetch in dev

  const fetchAdvice = async () => {
    try {
      setLoading(true);
      const res = await fetch(
        `https://api.adviceslip.com/advice?${Math.random()}`
      );
      const data = await res.json();

      setTimeout(() => {
        setAdviceData(data.slip);
        setLoading(false);
        setCount((prev) => prev + 1);
        console.log("Advice fetched:", data.slip);
      }, 100);
    } catch (error) {
      console.error("Error fetching advice:", error);
      setAdviceData({ id: "-", advice: "Something went wrong." });
      setLoading(false);
    }
  };

  useEffect(() => {
    if (!hasFetched.current) {
      hasFetched.current = true;
      fetchAdvice();
    }
  }, []);

  return (
    <div className="advice-container">
      <h1 className="advice-text">
        {loading
          ? "Loading advice..."
          : `ID: ${adviceData?.id} — "${adviceData?.advice}"`}
      </h1>

      <button className="advice-btn" onClick={fetchAdvice} disabled={loading}>
        {loading ? "Loading..." : "Get New Advice"}
      </button>

      <p className="fetch-count">
        Advice fetched: {count} time{count !== 1 ? "s" : ""}
      </p>
    </div>
  );
};
