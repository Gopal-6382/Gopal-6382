import PropTypes from "prop-types";

export const ColorBox = ({ color }) => {
  return (
    <div
      style={{
        backgroundColor: color,
        padding: "20px",
        color: "white",
        textAlign: "center",
        borderRadius: "8px",
        marginBottom: "10px"
      }}
    >
      This box is {color}
    </div>
  );
};

// Restrict allowed values to only: "red", "blue", or "green"
ColorBox.propTypes = {
  color: PropTypes.oneOf(["red", "blue", "green"]).isRequired,
};
