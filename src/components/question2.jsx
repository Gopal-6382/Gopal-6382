import { useState, useEffect, useCallback } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const sampleQuestions = [
  {
    question: "What is the capital of France?",
    options: ["Berlin", "Paris", "Madrid", "Rome"],
    correct_answer: "Paris",
  },
  {
    question: "Who wrote 'Romeo and Juliet'?",
    options: ["Shakespeare", "Hemingway", "Tolstoy", "Twain"],
    correct_answer: "Shakespeare",
  },
  {
    question: "What is 2 + 2?",
    options: ["3", "4", "5", "22"],
    correct_answer: "4",
  },
  {
    question: "Which planet is known as the Red Planet?",
    options: ["Earth", "Venus", "Mars", "Jupiter"],
    correct_answer: "Mars",
  },
  {
    question: "What language is used for web apps?",
    options: ["Python", "Java", "JavaScript", "C++"],
    correct_answer: "JavaScript",
  },
];

function QuizApp() {
  const [questions, setQuestions] = useState([]);
  const [currentQuestion, setCurrentQuestion] = useState(0);
  const [selectedOption, setSelectedOption] = useState(null);
  const [score, setScore] = useState(0);
  const [showResult, setShowResult] = useState(false);
  const [timeLeft, setTimeLeft] = useState(30);
  const [timerActive, setTimerActive] = useState(false);
  const [showExplanation, setShowExplanation] = useState(false);

  useEffect(() => {
    setQuestions(sampleQuestions);
  }, []);

  useEffect(() => {
    let timer;
    if (timerActive && timeLeft > 0) {
      timer = setInterval(() => setTimeLeft((prev) => prev - 1), 1000);
    } else if (timeLeft === 0) {
      handleNextQuestion();
    }
    return () => clearInterval(timer);
  }, [timerActive, timeLeft, handleNextQuestion]);

  const handleOptionClick = (option) => {
    setSelectedOption(option);
  };

  const handleSubmit = () => {
    const currentQ = questions[currentQuestion];
    if (selectedOption === currentQ.correct_answer) {
      setScore((prev) => prev + 1);
    }
    setShowExplanation(true);
    setTimerActive(false);
  };

  const handleNextQuestion = useCallback(() => {
    setShowExplanation(false);
    setSelectedOption(null);
    setTimeLeft(30);
    if (currentQuestion + 1 < questions.length) {
      setCurrentQuestion((prev) => prev + 1);
      setTimerActive(true);
    } else {
      setShowResult(true);
    }
  }, [currentQuestion, questions.length]);

  const handleStart = () => {
    setQuestions(sampleQuestions);
    setCurrentQuestion(0);
    setScore(0);
    setSelectedOption(null);
    setShowResult(false);
    setShowExplanation(false);
    setTimeLeft(30);
    setTimerActive(true);
  };

  return (
    <div className="container my-5">
      <h2 className="text-center mb-4">🧠 Simple Quiz App</h2>

      {showResult ? (
        <div className="text-center">
          <h3>
            ✅ Final Score: {score} / {questions.length}
          </h3>
          <button className="btn btn-primary mt-3" onClick={handleStart}>
            Restart Quiz
          </button>
        </div>
      ) : questions.length > 0 ? (
        <div className="card shadow p-4">
          <h5>
            Question {currentQuestion + 1}/{questions.length}
          </h5>
          <p className="fw-bold">{questions[currentQuestion].question}</p>
          <div className="d-grid gap-2 mb-3">
            {questions[currentQuestion].options.map((opt, idx) => (
              <button
                key={idx}
                className={`btn ${
                  selectedOption === opt
                    ? "btn-secondary"
                    : "btn-outline-secondary"
                }`}
                onClick={() => handleOptionClick(opt)}
                disabled={showExplanation}
              >
                {opt}
              </button>
            ))}
          </div>

          {!showExplanation && (
            <button
              className="btn btn-success"
              onClick={handleSubmit}
              disabled={selectedOption === null}
            >
              ✅ Submit
            </button>
          )}

          {showExplanation && (
            <>
              <div
                className={`alert ${
                  selectedOption === questions[currentQuestion].correct_answer
                    ? "alert-success"
                    : "alert-danger"
                } mt-3`}
              >
                {selectedOption === questions[currentQuestion].correct_answer
                  ? "Correct!"
                  : `Incorrect. Correct Answer: ${questions[currentQuestion].correct_answer}`}
              </div>
              <button
                className="btn btn-info mt-2"
                onClick={handleNextQuestion}
              >
                ➡ Next Question
              </button>
            </>
          )}

          <div className="text-end text-muted mt-3">
            ⏱ Time Left: <strong>{timeLeft}s</strong>
          </div>
        </div>
      ) : (
        <div className="text-center">
          <button className="btn btn-primary" onClick={handleStart}>
            Start Quiz
          </button>
        </div>
      )}
    </div>
  );
}

export default QuizApp;
