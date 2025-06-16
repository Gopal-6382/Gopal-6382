const list = ["Gopal", "Krishnan", "Suresh", "Ramesh", "Ganesh", "Mahesh"];
const List = () => {
  return (
    <div className="container mt-5">
      <h1 className="text-center">List of Names</h1>
      <ul className="list-group pt-3">
        {list.map((name, index, l) => (
          <li key={index} className="list-group-item">
            {name}
            {" -> Index -> "}
            {index}
            {/*{l}*/}
          </li>
        ))}
      </ul>
    </div>
  );
};
export default List;
