import  { useReducer } from "react";

// Initial state
const initialState = { count: 0 };

// Reducer function
function reducer(state, action) {
  switch (action.type) { // 👈 use 'type', not 'hi'
    case "increment":
      return { count: state.count + 1 };
    case "decrement":
      return { count: state.count - 1 };
    default:
      return state;
  }
}

function CounterWithReducer() {
  // useReducer accepts reducer function and initial state
  const [state, dispatch] = useReducer(reducer, initialState); // 👈 corrected

  return (
    <div>
      <h2>useReducer Counter: {state.count}</h2>
      <button onClick={() => dispatch({ type: "increment" })}>Increment</button> {/* 👈 use 'type' */}
      <button onClick={() => dispatch({ type: "decrement" })}>Decrement</button>
    </div>
  );
}

export default CounterWithReducer;
