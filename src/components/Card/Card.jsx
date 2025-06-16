// // function User({ name, city, description, skills }) {
// //   return (
// //     <div className="card-container">
// //       <span className="badge">Online</span>
// //       <img src="/vite.svg" className="avatar" alt="User Avatar" />
// //       <h3>{name}</h3>
// //       <p className="name">{description}</p>
// //       <h6 className="s">{city}</h6>

// //       <div className="buttons">
// //         <button className="primary">Message</button>
// //         <button className="primary outline">Following</button>
// //       </div>

// //       <div className="skills">
// //         <h6>Skills</h6>
// //         <ul className="skills-list">
// //           {skills.map((skill, index) => (
// //             <li key={index}>{skill}</li>
// //           ))}
// //         </ul>
// //       </div>
// //     </div>
// //   );
// // }

// const userData = [
//   {
//     name: "Gopal Krishnan",
//     city: "Palani",
//     description: "Frontend Developer",
//     skills: ["React", "TypeScript", "Tailwind", "Redux", "SCSS", "Next.js","React", "TypeScript", "Tailwind", "Redux", "SCSS", "Next.js"],
//     online: false,
//     avatar: "/vite.svg",
//   },
//   {
//     name: "Anjali Sharma",
//     city: "Delhi",
//     description: "UI/UX Designer",
//     skills: ["Figma", "Sketch", "Illustrator", "CSS", "HTML"],
//     online: true,
//     avatar: "/vite.svg",
//   },
//   {
//     name: "Rahul Mehta",
//     city: "Bangalore",
//     description: "Full Stack Developer",
//     skills: ["Node.js", "React", "MongoDB", "Express", "GraphQL"],
//     online: true,
//     avatar: "/vite.svg",
//   },
//   {
//     name: "Priya Singh",
//     city: "Mumbai",
//     description: "Backend Developer",
//     skills: ["Node.js", "PostgreSQL", "Docker", "AWS"],
//     online: false,
//     avatar: "/vite.svg",
//   },
//   {
//     name: "Kiran Das",
//     city: "Kochi",
//     description: "DevOps Engineer",
//     skills: ["AWS", "Docker", "Jenkins", "Kubernetes"],
//     online: true,
//     avatar: "/vite.svg",
//   },
// ];

// function User(props) {
//   return (
//     <div className="card-container">
//       <span className={props.online ? "badge online" : "badge offline"}>
//         {props.online ? "Online" : "Offline"}
//       </span>
//       <img src={props.avatar} className="avatar" alt="User Avatar" />
//       <h3>{props.name}</h3>
//       <p className="name">{props.description}</p>
//       <h6 className="s">{props.city}</h6>

//       <div className="buttons">
//         <button className="primary">Message</button>
//         <button className="primary outline">Following</button>
//       </div>

//       <div className="skills">
//         <h6>Skills</h6>
//         <ul className="skills-list">
//           {props.skills.map((skill, index) => (
//             <li key={index}>{skill}</li>
//           ))}
//         </ul>
//       </div>
//     </div>
//   );
// }
// function User2(props) {
//   return (
//     <div className="card-container">
//       <span className={props.online ? "badge online" : "badge offline"}>
//         {props.online ? "Online" : "Offline"}
//       </span>
//       <img src={props.avatar} className="avatar" alt="User Avatar" />
//       <h3>{props.name}</h3>
//       <p className="name">{props.description}</p>
//       <h6 className="s">{props.city}</h6>

//       <div className="buttons">
//         <button className="primary">Message</button>
//         <button className="primary outline">Following</button>
//       </div>

//       <div className="skills">
//         <h6>Skills</h6>
//         <ul className="skills-list">
//           {props.skills.map((skill, index) => (
//             <li key={index}>{skill}</li>
//           ))}
//         </ul>
//       </div>
//     </div>
//   );
// }
// // export const Card = () => {
// //   return (
// //     <User
// //       name="Gopal Krishnan"
// //       city="Palani"
// //       description="Frontend Developer"
// //       skills={["React", "TypeScript", "Tailwind", "Redux", "SCSS", "Next.js"]}
// //       online={false}
// //       avatar="/vite.svg"
// //     />
// //   );
// // };

// export const Card = () => {
//   return (
//     <>
//       {userData.map((user, index) => (
//         <User
//           key={index}
//           name={user.name}
//           city={user.city}
//           description={user.description}
//           skills={user.skills}
//           online={user.online}
//           avatar={user.avatar}
//         />
//       ))}
//     </>
//   );
// };

// User.jsx
export function User(props) {
  return (
    <div className="card-container">
      <span className={props.online ? "badge online" : "badge offline"}>
        {props.online ? "Online" : "Offline"}
      </span>
      <img src={props.avatar} className="avatar" alt="User Avatar" />
      <h3>{props.name}</h3>
      <p className="name">{props.description}</p>
      <h6 className="s">{props.city}</h6>

      <div className="buttons">
        <button className="primary">Message</button>
        <button className="primary outline">Following</button>
      </div>

      <div className="skills">
        <h6>Skills</h6>
        <ul className="skills-list">
          {props.skills.map((skill, index) => (
            <li key={index}>{skill}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

const userData = [
  {
    name: "Gopal Krishnan",
    city: "Palani",
    description: "Frontend Developer",
    skills: [
      "React",
      "Vite",
      "Tailwind",
      "React",
      "Vite",
      "Tailwind",
      "Redux",
      "SCSS",
      "Next.js",
      "TypeScript",
      "Redux",
      "SCSS",
      "Next.js",
      "TypeScript",
      "Tailwind",
      "Redux",
      "SCSS",
      "Next.js",
    ],
    online: true,
    avatar: "/vite.svg",
  },
  {
    name: "Asha Kumar",
    city: "Chennai",
    description: "UI/UX Designer",
    skills: ["Figma", "Sketch", "HTML", "CSS"],
    online: false,
    avatar: "/vite.svg",
  },
  {
    name: "Rahul Dev",
    city: "Bangalore",
    description: "Fullstack Engineer",
    skills: ["Node.js", "React", "MongoDB", "Express", "Docker"],
    online: true,
    avatar: "/vite.svg",
  },
  {
    name: "Neha Sharma",
    city: "Delhi",
    description: "Frontend Developer",
    skills: ["Vue", "Sass", "Pinia", "HTML"],
    online: false,
    avatar: "/vite.svg",
  },
  {
    name: "Sundar Raj",
    city: "Madurai",
    description: "React Developer",
    skills: [
      "React",
      "Vite",
      "Tailwind",
      "React",
      "Vite",
      "Tailwind",
      "Redux",
      "SCSS",
      "Next.js",
      "TypeScript",
      "Redux",
      "SCSS",
      "Next.js",
      "TypeScript",
      "Tailwind",
      "Redux",
      "SCSS",
      "Next.js",
    ],
    online: true,
    avatar: "/vite.svg",
  },
];

export const Card = () => {
  return (
    <div className="card-grid">
      {userData.map((user, index) => (
        <User key={index} {...user} />
      ))}
    </div>
  );
};
