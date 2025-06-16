export const Student = ({
  name = "please enter name",
  age = 0,
  married = false,
}) => {
  return (
    <div className="student mt-4">
      <table className="table table-responsive text-center table-striped table-hover">
        <thead className="table-dark">
          <tr>
            <th>Field</th>
            <th>Value</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>Name</td>
            <td>{name}</td>
          </tr>
          <tr>
            <td>Age</td>
            <td>{age}</td>
          </tr>
          <tr>
            <td>Married</td>
            <td>{married ? "Yes" : "No"}</td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};
