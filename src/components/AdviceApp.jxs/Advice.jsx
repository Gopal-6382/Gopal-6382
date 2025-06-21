import  { useState, useEffect } from "react";
import "../../sass/advice.scss";

export const Advice = () => {
  const [adviceData, setAdviceData] = useState(null);
  const [loading, setLoading] = useState(false);
  const [count, setCount] = useState(0);

  const fetchAdvice = async () => {
    try {
      setLoading(true);
      const res = await fetch(
        `https://api.adviceslip.com/advice?${Math.random()}`
      );
      const data = await res.json();
      setAdviceData(data.slip); // holds { id, advice }
      setCount((prev) => prev + 1);
      console.log("Advice fetch count:", count + 1);
    } catch (error) {
      console.error("Error fetching advice:", error);
      setAdviceData({ id: "-", advice: "Something went wrong." });
    } finally {
      setLoading(false);
    }
  };
  //for initial calling when automaticall the adivce
  useEffect(() => {
    fetchAdvice();
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
