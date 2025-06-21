import "./index.scss";
import { Header, Header2 } from "./Header";
import Props from "./props";
import { ColorBox } from "./ColorBox";

const App = () => {

  
  // Function to handle button click
  const handleClick = () => {
    alert("Button clicked!");
  };

  return (
    <div className="container mt-5 text-center">
      <h1 className="text-primary">Hello, World!</h1>
      <p className="lead">
        This is a simple React + Bootstrap + Sass application.
      </p>
      <button className="btn btn-success" onClick={handleClick}>
        Click Me
      </button>
    </div>
  );
};

const App5 = () => {
  return (
    <div className="container mt-5">
      <h2>ColorBox Example</h2>
      <ColorBox color="red" />
      <ColorBox color="blue" />
      <ColorBox color="yellow" />
      {/* <ColorBox color="yellow" />  <-- This will show a warning in console! */}
    </div>
  );
};

const App2 = () => <Header />;
const App3 = () => <Header2 />;
const App4 = () => <Props />;

export { App, App2, App3, App4 ,App5};
