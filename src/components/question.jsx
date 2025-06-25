import React, { useState, useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js"; // Bootstrap JS for Accordion

const questionBank = Array.from({ length: 20 }).map((_, i) => ({
  id: i + 1,
  question: `What is ${i + 2} + ${i + 3}?`,
  options: [`${i}`, `${i + 3}`, `${i + 5}`, `${i + 6}`],
  correct: 2,
  explanation: `Because ${i + 2} + ${i + 3} = ${i + 5}`,
}));

const Question = () => {
  const [answers, setAnswers] = useState({});
  const [submitted, setSubmitted] = useState(false);
  const [showModal, setShowModal] = useState(false);
  const [time, setTime] = useState(0);
  const [openAccordions, setOpenAccordions] = useState({});

  useEffect(() => {
    const interval = setInterval(() => setTime((t) => t + 1), 1000);
    return () => clearInterval(interval);
  }, []);

  const formatTime = (t) =>
    `${String(Math.floor(t / 60)).padStart(2, "0")}:${String(t % 60).padStart(2, "0")}`;

  const handleOptionClick = (qid, idx) => {
    if (!submitted) {
      setAnswers((prev) => ({ ...prev, [qid]: idx }));
      setOpenAccordions((prev) => ({ ...prev, [qid]: true }));
    }
  };

  const handleSubmit = () => setSubmitted(true);

  const getButtonClass = (qid, idx) => {
    const selected = answers[qid];
    const correct = questionBank[qid - 1].correct;

    if (selected === undefined) return "outline-secondary";
    if (idx === correct) return "success";
    if (idx === selected && selected !== correct) return "danger";
    return "outline-secondary";
  };

  const correctCount = questionBank.reduce(
    (acc, q) => (answers[q.id] === q.correct ? acc + 1 : acc),
    0
  );

  return (
    <div className="container my-5">
      <h2 className="text-center mb-3">TCS/Wipro Style Assessment</h2>
      <div className="text-end text-muted mb-4">
        🕒 Time Spent: <strong>{formatTime(time)}</strong>
      </div>

      {questionBank.map((q) => {
        const selected = answers[q.id];
        const isCorrect = selected === q.correct;

        return (
          <div className="card mb-4" key={q.id}>
            <div className="card-header">
              <strong>Q{q.id}:</strong> {q.question}
            </div>
            <div className="card-body">
              {q.options.map((opt, idx) => (
                <button
                  key={idx}
                  className={`btn btn-${getButtonClass(q.id, idx)} mb-2 w-100 text-start`}
                  onClick={() => handleOptionClick(q.id, idx)}
                  disabled={submitted}
                >
                  {String.fromCharCode(65 + idx)}. {opt}
                </button>
              ))}

              {selected !== undefined && (
                <div className="accordion mt-3" id={`accordion${q.id}`}>
                  <div className="accordion-item">
                    <h2 className="accordion-header" id={`heading${q.id}`}>
                      <button
                        className={`accordion-button ${
                          openAccordions[q.id] ? "" : "collapsed"
                        } ${isCorrect ? "bg-success text-white" : "bg-warning"}`}
                        type="button"
                        data-bs-toggle="collapse"
                        data-bs-target={`#collapse${q.id}`}
                        aria-expanded={openAccordions[q.id] ? "true" : "false"}
                        aria-controls={`collapse${q.id}`}
                      >
                        {isCorrect ? "✅ Correct Answer" : "❌ Explanation"}
                      </button>
                    </h2>
                    <div
                      id={`collapse${q.id}`}
                      className={`accordion-collapse collapse ${
                        openAccordions[q.id] ? "show" : ""
                      }`}
                      aria-labelledby={`heading${q.id}`}
                    >
                      <div className="accordion-body">
                        <p>
                          <strong>Your Answer:</strong>{" "}
                          {q.options[selected] || "Not Answered"}
                        </p>
                        <p>
                          <strong>Correct Answer:</strong> {q.options[q.correct]}
                        </p>
                        <p>
                          <strong>Explanation:</strong> {q.explanation}
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
              )}
            </div>
          </div>
        );
      })}

      {!submitted ? (
        <div className="text-center">
          <button className="btn btn-success" onClick={handleSubmit}>
            ✅ Submit All Answers
          </button>
        </div>
      ) : (
        <div className="text-center">
          <button className="btn btn-primary" onClick={() => setShowModal(true)}>
            🔍 Review All Answers ({correctCount} / {questionBank.length})
          </button>
        </div>
      )}

      {/* Modal */}
      {submitted && showModal && (
        <div
          className="modal fade show d-block"
          tabIndex="-1"
          role="dialog"
          style={{ backgroundColor: "rgba(0,0,0,0.5)" }}
        >
          <div className="modal-dialog modal-lg modal-dialog-scrollable">
            <div className="modal-content">
              <div className="modal-header">
                <h5 className="modal-title">Answer Summary</h5>
                <button
                  type="button"
                  className="btn-close"
                  onClick={() => setShowModal(false)}
                ></button>
              </div>
              <div className="modal-body">
                <p>
                  ✅ You got <strong>{correctCount}</strong> out of {questionBank.length}
                </p>
                {questionBank.map((q) => (
                  <div key={q.id} className="mb-3">
                    <strong>Q{q.id}:</strong> {q.question}
                    <br />
                    <span>
                      Your Answer:{" "}
                      <strong
                        className={
                          answers[q.id] === q.correct
                            ? "text-success"
                            : "text-danger"
                        }
                      >
                        {q.options[answers[q.id]] || "Not Answered"}
                      </strong>
                    </span>
                    <br />
                    <span>Correct Answer: {q.options[q.correct]}</span>
                  </div>
                ))}
              </div>
              <div className="modal-footer">
                <button
                  className="btn btn-secondary"
                  onClick={() => setShowModal(false)}
                >
                  Close
                </button>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default Question;
