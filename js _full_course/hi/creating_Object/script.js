/*
const person1 = {
  name: "Gopal",
  age: 19,
  gender: "Male",
  job: "Developer"
};
console.log(person1);
const person4 = new Object();
person4.name = "john";
person4.age = 50;
person4.job = "Developer";
console.log(person4);
const person3 = {
  satHello: function () {
    console.log(`Hello,my name is ${this.name}`);
  }
}
const person = Object.create(person3);
person.name = "John";
person.age = 55;
person.job = "Developer";
console.log(person);
person.satHello();


class Person6 {
  constructor(name, age, job) {
    this.name = name;
    this.age = age;
    this.job = job;
  }
}
const person7 = new Person6("gopal", 25, "Devloper");
console.log(person7);

//Dot Notation Brakets Notation in JavaScript
const user1 = {
  name: "Tutore",
  age: 30,
  job: "Developer"
}
console.table(user1);

user1.name = "Joes";
console.log(user1.name);
console.log(user1);

//Brackets Notation
console.log(user1["age"]);
user1["age"] = 100;
console.log(user1["age"]);

const prop = "name";
console.log(user1[prop]);
console.log(user1.prop);


let user6 = {
  "first name": "Gopal",
  "Last name": "Krishnan"
};
console.log(user6["first name"]);
console.log(user6["Last name"]);

let key = 'first name';
console.log(user6[key]);

//
const user9 = {
  name: "Gopal",
  age: 30,
  job: "Programmer"
};
console.log(user9);
for (let key in user9) {
  console.log(`${key}:  ${user9[key]}`);
}

const keys = Object.keys(user9);
console.log(keys);
keys.forEach(keys => {
  console.log(`${key}:${user9[keys]}`);
});

const values = Object.values(user9);
console.log(values);
keys.forEach(values => {
  console.log(`${values}`);
});

const entries = Object.entries(user9);
console.log(entries);
entries.forEach(entry => {
  console.log(`$entry{[0]}:${entry[1]}`)
});


for (let i = 0; i < entries.length; i++) {
  console.log(`${entries[i][0]}:${entries[i][1]}`);
}

const user0 = [
  { name: "Gopal", age: 25, email: "gopalkrishan.com" },
  { name: "Ponnu", age: 10, email: "dknfdnljhfh.com" },
  { name: "kannu", age: 11, email: "fjlfffjfjh.com" }
];
console.log(user0);
for (const user of user0) {
  // console.log(user);
  console.log(user.name);
}
const olderUsers = user0.filter(user => user.age > 10);

console.log(olderUsers);

//Functiono in javascript
function add1(a, b) {
  return a + b;
}
console.log(add1(12, 22));
console.log(add1(12, 2242));
console.log(add1(12, 222));


function sum() {
  let total = 0;
  for (let i = 0; i < arguments.length; i++) {
    total += arguments[i];
  }
  return total;
}
console.log(sum(22, 12, 23, 44, 22, 55));
console.log(sum(22, 132, 223, 444, 242, 45));

function total(...args) {
  let total = 0;
  for (let i = 0; i < args.length; i++) {
    total += args[i];
  }
  return total;
}
console.log(sum(22, 12, 22, 44, 42, 45));
console.log(sum(22, 32, 23, 44, 22, 45));


//Function expression
const add = function (a, b) {
  return a + b;
}
console.log(add);
console.log(add(25, 78));

//Arrow Function
//const functionName=(parameters)=>{function body};
const ad = (a, b) => { return a + b; };
console.log(add);
console.log(add(25, 60));
let numbers = [1, 2, 3, 4, 5, 6];
let doubledNumbers = numbers.map(number => number * 2);
console.log(doubledNumbers);

let words = ['apple', 'banana', 'orange', 'orange'];
let filterwords = words.filter(word => word.length > 3);
console.log(filterwords);


let total1 = numbers.reduce((sum, number) => sum + number, 0);
console.log(total);

let counter = () => {
  let count = 0;
  return () => {
    count++;
    return count;
  }
};
let count = counter();
console.log(count());
console.log(count());
console.log(count());
console.log(count());
*/


/*
user4 = {
  name: "Gopal",
  age: 18,
  work: "Programmer"
}

for (let key in user4) {
  console.log(`${key}: ${user4[key]}`)
}

const key1 = Object.keys(user4);
keys.forEach((key1) => {
  console.log(`${key}:${user4[key1]}`);
});


/*
for (let key in user9) {
  console.log(`${key}:${user9[key]}`);
}

const keys = Object.keys(user9);
keys.forEach(keys => {
  console.log(`${keys}:${user9[keys]}`);
});


const values = Object.values(user9);
values.forEach(values => {
  console.log(`${values}`);
});*/
/*
person = {
  name: "gopal",
  age: 21,
  gender: "male1",
  character: "Not Bad"
}
console.log(person);
person3 = {
  Say: function () { console.log(`My name is ${person.name}`); }
}
person1 = Object.create(person3);

person1.Say();
person2 = new Object();
person2.age = 12;
person2.name = "Gopal";
person2.gender = "male";
person2.character = "Not Bad";
console.log(person2);
*/

/*
class person{
  constructor(name,age,role){
    this.name=name;
    this.role=role;
    this.age=age;
  }
}
person1=new person("gopal",27,"Web developer");
console.log(person1);
*/

/*
user1 = {
  name: "Tutore",
  age: 30,
  job: "Developer"
}

console.log(user1);
console.log(user1.age);
console.log(user1['job']);
user1['job']="fullstack";
console.log(user1['job']);
let name1="name";
console.log(user1[name1]);
console.log(user1.name1);
*/
/*
let user6 = {
  "first name": "Gopal",
  "Last name": "Krishnan"
};
console.log(user6["first name"]);
console.log(user6["Last name"]);

let key = 'first name';
console.log(user6[key]);
*/
/*
const user0 = [
  { name: "Gopal", age: 25, email: "gopalkrishan.com" },
  { name: "Ponnu", age: 7, email: "dknfdnljhfh.com" },
  { name: "kannjytu", age: 16, email: "fjlfffjjtyfjh.com" },
  { name: "kanjynu", age: 20, email: "fjlfffjfjyjth.com" },
  { name: "kanjytnu", age: 6, email: "fjlfffjtrrjfjh.com" }
];
console.log(user0);
for (const user of user0) {
  // console.log(user);
  console.log(user.name);
}
const olderUsers = user0.filter(user => user.age > 10);

console.log(olderUsers);
*/



/*function add1(a, b) {
  return a + b;
}
console.log(add1(12, 22));
console.log(add1(12, 2242));
console.log(add1(12, 222));


function sum() {
  let total = 0;
  for (let i = 0; i < arguments.length; i++) {
    total += arguments[i];
  }
  return total;
}
console.log(sum(22, 12, 23, 44, 22, 55));
console.log(sum(22, 132, 223, 444, 242, 45));

function total(...args) {
  let total = 0;
  for (let i = 0; i < args.length; i++) {
    total += args[i];
  }
  return total;
}
console.log(sum(22, 12, 22, 44, 42, 45));
console.log(sum(22, 32, 23, 44, 22, 45));


//Function expression
const add = function (a, b) {
  return a + b;
}
console.log(add);
console.log(add(25, 78));

//Arrow Function
//const functionName=(parameters)=>{function body};
const ad = (a, b) => { return a + b; };
console.log(add);
console.log(add(25, 60));
let numbers = [1, 2, 3, 4, 5, 6];
let doubledNumbers = numbers.map(number => number * 2);
console.log(doubledNumbers);

let words = ['apple', 'banana', 'orange', 'orange'];
let filterwords = words.filter(word => word.length > 3);
console.log(filterwords);


let total1 = numbers.reduce((sum, number) => sum + number, 0);
console.log(total);

let counter = () => {
  let count = 0;
  return () => {
    count++;
    return count;
  }
};
let count = counter();
console.log(count());
console.log(count());
console.log(count());
console.log(count());
*/

function sum(a, b) {
  return a + b;
}
console.log(sum(9, 9));

function sum1() {
  let n = 0;
  for (let i = 0; i < arguments.length; i++) {
    n += arguments[i];
  }
  return n;
}
console.log(sum1(9, 9, 12, 32));

function sum2(...args) {
  for (let i = 0; i < args.length; i++) {
    args[i];
  }
  return args;
}
console.log(sum2(9, 9, 12, 32));

hey = function (a, b) {
  return (a + b) * (a - b);
}
console.log(hey(9, 9));

k = (a, b) => {
  return a + b;
}
console.log(k(10, 30));

numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
double = numbers.map(numbers => numbers * 2);
console.log(double);

let words = ['apple', 'banana', 'orange', 'orange'];
len = words.filter(words => words.length > 5);
console.log(len);

let counter = () => {
  count = 0;
  return () => {
    count++;
  return count;
}
}
let count1 = counter();

console.log(count1());
console.log(count1());
console.log(count1());
console.log(count1());
console.log(count1());

