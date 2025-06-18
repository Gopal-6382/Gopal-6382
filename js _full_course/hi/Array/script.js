/*
const numn = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
let A = numn.map((value) => {
  return Math.random() * value;
});
console.log(A);

let u = [1, 3, 5, 45, 543, 35, 4, 5];
console.log(u.splice(2));
let u1 = [1, 3, 5, 45, 543, 35, 4, 5];
let r=u1.splice(2, 4);
console.log(r);

let u2 = [1, 3, 5, 45, 543, 35, 4, 5];
console.log(u2.slice(2, 4));

const a = [10, 20, 30];
const b = [40, 50, 60];
const c = [70, 80, 90];
console.log(a);
console.log(a.concat(b));
console.log(a.concat(b, c));

let v = [22, 321, 111, 321, 412, 321, 221,];
let v1 = [22, 321, 111, 321, 412, 321, 221,];
console.log(v.sort());
let k = v1.sort();
console.log(k);
let v3 = [22, 321, 111, 321, 412, 321, 221,];
let k1 = v3.sort((a, b) => {
  return b - a;
});
console.log(k1);
const name1 = ["Kumar", "Aura", "sjdnl", "fasdf", "ufe", "Gred"];
console.log(name1.sort());
let n1 = name1.sort((b, a) => {
  return a-b;
  });
console.log(n1);
  
const products = ["Pen", "Pencil", "Pencil","Eraser", "Box", "Pen"];
var y=products.includes("Pen");
console.log(products.includes("Pen",6));
console.log(y);
let v8 = [22, 321, 111, 321, 412, 321, 221,];
var p=v8.fill(20,4);
console.log(p);

let v9= [22, 321, 111, 321, 412, 321, 221,];
var i=v9.fill(20,2,4);
console.log(i);

const products2 = ["Pen", "Pencil", "Eraser", "Box"];
console.log(products2.join("😍"));

const products3 = ["Pen", "Pencil", "Eraser", "Box"];
var v10=products3.join(" || ");
console.log(v10);

const o=[1,2,3,4,5,6,7];
const g=o.reverse();
console.log(o);

const o1=[1,2,3,4,5,6,7];
console.log(o1.reverse());
const j = { 0: 1, 1: 32, 2: 47, 3: 43, 4: 22, 5: 8, length: 6 };
Array.prototype.reverse.call(j);
console.log(j);

let n = [1, 2, 3, 4, 5];
n.push(2);
console.log(n);
n.push(2,4,5,78,8,[23,54,65,6,56,6,56,5,]);
console.log(n);

let fruits = ["Apple"];
fruits.push("Orange");
console.log(fruits);
let d=fruits.push("Ornge",["ioreaha","rejaf"]);
console.log(fruits.push(d));
fruits.push("Orange");
console.log(fruits);


let user4=[21,44,34,324,124,34,"$324","$23432","$23432","34242433"];
let user7=[1,4,4,32,14,34,"$24","$2432","$2k432","gs42ds33"];
user4.push(...user7);
console.log(user4);
*/
/*
let a=[10,20,30,40,"hi"];
let b=new Array(10,20,30,40);
console.log(b);
let c=new Array(10,'$',"Gopa",40.09890);
console.log(c);
console.table(c);
console.table(a);
*/
/*
//For each
const num = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
//value ,index, array value is compulsary
num.forEach((value, index) => {
  console.log(value + " : " + index);
});
const users = [
  { Fname: "gopal", age: 12, city: "Salem", salary: 10000 },
  { Fname: "Arfin", age: 22, city: "karur", salary: 10231 },
  { Fname: "Mani", age: 12, city: "chennai", salary: 10324 },
  { Fname: "Agilan", age: 18, city: "coimbotore", salary: 10234 },
  { Fname: "Sanjay", age: 16, city: "madhurai", salary: 10234 },
  { Fname: "Sanjay", age: 12, city: "kanniya kumari", salary: 10432 },
];
console.table(users);
users.forEach((value, index) => {
  console.log(value.Fname + " " + index);
})
*/

/*
//Map (value,index,array);
const num = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
let sqrt = num.map((value) => {
  return Math.sqrt(value).toFixed(8);
});
console.log(sqrt);
console.table(sqrt);
let v = sqrt.map((value) => {
  return Math.round(value);
});
console.table(v);

const users = [
  { Fname: "gopal", age: 12, city: "Salem", salary: 10000 },
  { Fname: "Arfin", age: 22, city: "karur", salary: 10231 },
  { Fname: "Mani", age: 12, city: "chennai", salary: 10324 },
  { Fname: "Agilan", age: 18, city: "coimbotore", salary: 10234 },
  { Fname: "Sanjay", age: 16, city: "madhurai", salary: 10234 },
  { Fname: "Ponnumani", age: 12, city: "kanniya kumari", salary: 10432 },
];
console.table(users);
let eligible = users.map((users) => ({
  Fname:((users.Fname)==("gopal"||"Mani") )? "ture":"not",
  age: users.age,
  city: users.city,
  salary: users.age,
  status: users.age >= 18 ? "eligible" : "Not Eligible"
}));
console.table(eligible);
*/
/*
//Slice (start,end)
const number = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
console.log(number);
let k=number.slice(7);
console.log(k);
console.log(number);
console.log(number.slice(8,9));
*/
/*
//Splice is to Remove Element in array 
//It will change original array
//removed_element=Splice(start,length,new elelment)

let a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let removed = a.splice(9);
console.log("Removed" + removed);
console.log(a);
let b = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let removed1 = b.splice(2, 4);//start to howmany element
console.log("Removed1 :" + removed1);


let c = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let removed2 = c.splice(2, 2, 25, 36, 12);
console.log("Removed" + removed2);
console.log(c);

console.log("--------------------------------")

let d = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let removed3 = d.splice(2, 2, [25, 36, 45]);
console.log("Removed" + removed3);
console.log(d);

let e = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let removed4 = e.splice(2, 0, 0, 36, 45);
console.log("Removed" + removed4);
console.log(e);
*/
/*

const a=[10,20,30];
const b=[40,50,60];
const c=[70,80,90];

let d=a.concat(b);
console.log(d);

d=a.concat(b,c);
console.log(d);

d=a.concat(b,c,25,3,53,53,34);
console.log(d);

d=a.concat(b,c,25,3,53,['a','b','d','d']);;
console.log(d);
console.table(d);

*/

/*

let v=[22,321,111,321,412,321,221,];
console.log(v.sort());

const name1=["Kumar","Aura","sjdnl","fasdf","ufe","Gred"];
console.log(name1.sort());
const name2=[14,24,24,24,21,2,2124,32,3312,3];
name2.sort((a,b)=>{
//return a-b;//Ascending 
return b-a;//descending
});
console.log(name2);

//Sort
const names=["Kumar","Aureen","Joes","Zara","Stanley"];
console.log("Before Sort :"+names);
names.sort();
console.log("After Sort : "+names);

const num=[10,100,25,150,45,80,9];
console.log("Before Sort : "+num);
k=num.sort();
console.log("After Sort : "+k);

num.sort((a,b)=>{
  return a-b;
});
console.log("Asc Compare Sort : "+num);
num.sort((a,b)=>{
  return b-a;
});
console.log("Desc Compare Sort : "+num);

const users =[
  {name:"Ram",age:12,city:"Salem",salary:10000},
  {name:"Sam",age:15,city:"Chennai",salary:10500},
  {name:"Ravi",age:22,city:"Namakkal",salary:12000},
  {name:"Joes",age:18,city:"Hosur",salary:6000},
  {name:"Aureen",age:47,city:"Dharmapuri",salary:10000},
  {name:"Stanley",age:10,city:"Salem",salary:8000},
];
console.table(users);

users.sort((a,b)=>{
  return a.age-b.age;
});
console.table(users);

users.sort((a,b)=>{
  if(a.name<b.name) return -1;
  return 0;
});

console.table(users);
*/
/*
//Fill(value,start,end)
let n=[1,2,3,4,5,6]
console.log("Before Fill : "+n);
n.fill(20,3,4);
n.fill(20,3);
n.fill(20);
console.log("After Fill  : "+n);
console.table(n);
*/
/*

//Includes(value,start_index)
const products = ["Pen", "Pencil", "Pencil","Eraser", "Box", "Pen"];
let result = products.includes("Pen");
console.log(result);
result = products.includes("Scale");
console.log(result);
result = products.includes("Pencil", 2);
console.log(result);
result = products.includes("Penfsa");
console.log(result);


//array.join(separator)
const products = ["Pen", "Pencil", "Eraser", "Box"];
console.log(products);

console.log(products.join()); //Deafult , as Separator
console.log(products.join('|')); // Pipe | as Separator
console.log(products.join('🤣')); // Pipe | as Separator

const a=[1,2,3,4,5,6,7];
console.log("Before Array"+a);
a.reverse();
console.log(a);

*/

/*
//Array element with Length Property
const x={0:10,1:2,2:0,3:40,4:350,5:360,length:6};
console.log(x);
Array.prototype.reverse.call(x);
console.log(x);

const n = [1, 2, 3, 4, 5, 6];
console.log("Before Reverse : ", n);
n.reverse();
console.log("After Reverse : ", n);

*/
/*
//Array Element With Length Property
const x = { 0: 180, 1: 230, 2: 302, 3: 340, length: 4 };
console.log(x);

Array.prototype.reverse.call(x);
console.log(x);
let n = [1, 2, 3, 4, 5];
console.log(n);
console.log(n.push(60));
console.log(n);
console.log(n.push(70, 85, 90, 100));
console.log(n);


let fruits = ["Apple"];
console.log(fruits);
fruits.push("Orange");
console.log(fruits);
fruits.push("Banana", "Pineapple");
console.log(fruits);
*/

/*

//Merging Two Arrays
let users1 = ["Ram", "Sam", "Ravi"];
let users2 = ["Rajesh", "Kumar"];

users1.push(...users1);
console.log(users1);


//POP in JavaScript.
const users = ['Ram', 'Sam', 'Ravi', 'Kumar'];
console.log(users);
console.log(users.pop());
console.log(users);
console.log(users.pop());
console.log(users);


//Shift()
let students = ["Kumar", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];

console.log("Before shift : " + students);
let element = students.shift();
let elemen = students.shift();
console.log("After shift : " + students);
console.log("Removed Element : " + element);
console.log("Removed Element : " + elemen);

console.log("Before shift : " + students);
element = students.shift();
console.log("After shift : " + students);
console.log("Removed Element : " + element);

*/
/*
//Unshift()
// Add First element at start
students = ["Kumar", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];
console.log("Before unshift : " + students);

let len = students.unshift("Tiya","Gopal");
console.log("Length : " + len);
console.log("After unshift : " + students);
console.log("Length : " + len);

//Mulitiple Values
console.log("After unshift : " + students);
let k=students.unshift("Riya", "Diya");
console.log(k);
console.log("After unshift : " + students);

students = ["Tiya", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];
let i = students.indexOf("Tiya");
console.log("Index : " + i);
console.log(students.indexOf("Tiya"));
let user = "Tutor Joes";
let index = user.indexOf("o");
console.log("Index : " + index);

index = user.indexOf("o", 5);
console.log("Index : " + index);
*/

/*
*/
/*

let originalArray = [1, 2, 6];
let clonedArray = [...originalArray];
console.log(clonedArray);  // [1, 2, 3]
let originalArray = [1, 2, 4];
let clonedArray = originalArray.slice();
console.log(clonedArray);  // [1, 2, 3]
let originalArray = [1, 2, 3];
let clonedArray = Array.from(originalArray);
console.log(clonedArray);  // [1, 2, 3];
let originalArray = [1, 2, 5];
let clonedArray = JSON.parse(JSON.stringify(originalArray));
console.log(clonedArray);  // [1, 2, 3];
const users=["Ram","Sam","Ravi"];
users.push("Tiya");
console.log(users);
*/
/*
const user = [
  { Fname: "gopal", age: 12, city: "Salem", salary: 10000 },
  { Fname: "Arfin", age: 22, city: "karur", salary: 10231 },
  { Fname: "Mani", age: 12, city: "chennai", salary: 10324 },];
user.forEach((value) => {
  let m =   value.age > 18 ? "yes" : "NO";
  let u =   value.salary > 10200 ? "kk" : "Nn";
 let k= value.Fname;
 console.log(k+"  "+ m + "  "+u);

}
);
*/
/*
students = ["Tiya", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];
console.log(students.pop());
h=students.pop();
i=students.pop();
j=students.pop();
k=students.pop();
console.log(h);
console.log(i);
console.log(j);
console.log(k);
console.log("-----------------------------------");
console.log("-----------------------------------");
console.log("-----------------------------------");
let students1 = ["Kumar", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];
i=students1.shift();
console.log(i);
i=students1.shift();
console.log(i);
console.log(students1);
rem=students1.shift();
console.log(rem);


students = ["Kumar", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];
console.log("Before unshift : " + students);
let len=students.unshift("Tiya","Aureen");
console.log(len);
console.log("After unshift : -------------------- "
   + students);

   let user = "Tutor Joes";
   let index = user.indexOf("o");
   console.log("Index : " + index);
   let user4= "Gopala krishna";
   console.log(user4.indexOf('k'));

students2 = ["Kumar", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];
console.log(students2.lastIndexOf("Joes"));


students = ["Tiya", "Aureen", "Joes", "Zara", "Stanley", "Rajesh"];
let i = students.indexOf("Tiya");
console.log("Index : " + i);
console.log(students.indexOf("Aureen"));
let user = "Tutor Joes";
let index = user.indexOf("o");
console.log("Index : " + index);
index = user.indexOf("o", 4);
console.log("Index : " + index);

*/

let originalArray1 = [1, 2, 6];
let clonedArray1 = [...originalArray1];
console.log(clonedArray1);  // [1, 2, 3]

let originalArray2 = [1, 2, 4];
let clonedArray2 = originalArray2.slice(1,2);
console.log(clonedArray2);  // [1, 2, ]

let originalArray3 = [1, 2, 3];
let clonedArray3 = Array.from(originalArray3);
console.log(clonedArray3);  // [1, 2, 3];

let originalArray4 = [1, 2, 5];
let clonedArray4 = JSON.parse(JSON.stringify(originalArray4));
console.log(clonedArray4);  // [1, 2, 3];
