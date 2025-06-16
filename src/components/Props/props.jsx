import { Student } from "./Student";
import { ChildComponents } from "./ChildComponents";

function Props() {
  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Props Example</h2>
      <Student name="John Doe" age={25} married={true} />
      <Student name="Gopal" age={25} married={true} />
      <Student />
      <ChildComponents className="child">
        <p className="lead border border-5 p-2 bg-body-tertiary">para 1</p>
        <p className="lead border border-5 p-2 bg-body-secondary">para 2</p>
        <p className="lead border border-5 p-2 bg-body-tertiary">para 3</p>
      </ChildComponents>
    </div>
  );
}

export default Props;
