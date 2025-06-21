
export const Header = () => {
  return React.createElement(
    "div",
    { className: "container mt-5 text-center" },
    React.createElement("h1", null, "Hello, World!"),
    React.createElement(
      "p",
      null,
      "This is a simple React + Bootstrap + Sass application."
    ),
    React.createElement("button", { className: "btn btn-success" }, "Click Me")
  );
};

export const Header2 = () => {
  const login = true;
  const greet = login ? "yes you can go to home" : "sorry please login";
  const greet2 = login ? (
    <p>yes you can go to home</p>
  ) : (
    <p>sorry please login</p>
  );

  return (
    <>
      <div className="container text-center mt-5">
        <h1 className="banner-text">Hello, World!</h1>
        <p className="slogan">Learn More, Be Smart</p>
      </div>
      <div className="container text-center mt-5">
        <p className="color">25 + 45 = {25 + 45}</p>
        <h1>{greet}</h1>
        {greet2}
      </div>
    </>
  );
};
