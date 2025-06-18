//operators in javascript

/*
arithmetic operators
let a=100;
let b=10;
let c;
c=a+b;
c=a-b;
c=a*b;
c=a/b;
c=a%b;
c=2**3;//2016 standard
c=++a;
c=--b;
console.log(c);
*/

/*
Assignment operators
 let a=100; 
 a=a+5;
 a+=5;
 a-=5;
 a*=5;
 a/=5;
 a%=5;
 console.log(a)
 */

/*
Maths operation
let c;
c=Math.PI;
c=Math.E;
c=Math.round(5.8);
c=Math.round(5.3);//when increase .3  that 5 .8 is 6
c=Math.floor(5.3);//remove dcecimal
c=Math.ceil(5.3);//next greaat value is 6
c=Math.sqrt(90);//square root
c=Math.abs(-90);//convert minus value into positive
c=Math.trunc(25.58);//give hole num remove points
c=Math.pow(2,3);//2*2*2
c=Math.min(10,20,30,40,50,60);
c=Math.max(10,20,30,40,50,60);
c=Math.random();
c=Math.floor((Math.random()*50+1));
c=Math.sign(23);//1
c=Math.sign(-12);//-1
c=Math.sign(0);//0
c=Math.sin(45);//teta value
c=Math.log(23);
console.log(c)
*/

//comparsion operators
/*
let a=10;
let b="10";
//this automatically convert the string and check that show true
console.log(a==b);
//this also check data type that string and int so false
console.log(a===b);

let a=10;
let b="10";
console.log(a!=b);
*/

/*Relational operators
let a=10;
let b=1;
console.log(a<b);
console.log(a>b);
console.log(a>=b);
console.log(a<=b);
*/

//Logical operator
/*
let a=40;
console.log(a>=35 && a<=100);
let b=0;
console.log(b>=35 || b<=100);//because the the 10 under 100
let c=false;
console.log(!c);

//Strict equality aor identify operator
let p=10;
console.log(p);
let w='10';
console.log(p==w);
console.log(p===w);
*/

/*Conditional or Ternary Operator (?!)
let age = 25;
result = age >= 18 ? "eligible" : "not"
console.log(result)
//Null handling values
function welcome(name) {
    let result = name ? name : "noname"
    console.log("welcome  " + name)
    console.log("welcome  " + result)
}
welcome();
welcome(null);
welcome('joes');
//Handle the object type value

user = { 'name': 'Gopal', 'age': 25 };
console.log(user.name);

const greet = (user) => {
    const name = user.name ? user.name : "NO Name";
    return "hello" + name;
}
console.log(greet(user));
let ag=18;
 let v=12;
resulr=ag>=18?v:"hi";
console.log(resulr);
*/
//Conditional chains
/*
avg >=90 a grade
avg >=80 b grade

const avg=85;
const grade=avg>=90?"A Grade":avg>=80?"B grade":"C grade";
console.log("Grade:",grade);
 */

//Bit wise operator
//And operator
/*
0010 =1 
0011 =2
0010
0010=2 0100=4
0010=2 0010=2
0010=2 0000=0
var a=2;
var b=3;
console.log(a&b);
const c=34;
const d=22;
console.log(c&d);
//a=a&b that assign to a
a&=b;
console.log(a);
*/

//Bitwise OR
/*let a = 12;//0000 0010
let b = 24;//0010 0100
console.log(a | b);
a |= b;
console.log(a);
//NOT Operator
let c = 25;//25+1=-26 covert minus
console.log(~c);
//XOR Operator
let e = 25;//0010 0101
let d = 26;//0010 0110
//aandb value 0000 0011
console.log(e ^ d);
e = e ^ d;
console.log(e);
//Left shif(<<) And Left shift assignment(>>=)
let g=5;
let h=2;
console.log(g<<h);
g<<=h;
console.log(g);
//Right Operator 
let t=100;
let u=2;
console.log(t>>u);
t>>=u;
console.log(t); //Nullish Coalescing operator(??)
 const a=null??"No value";
 const c=null??"15";
  console.log(c);
 console.log(a);
 const b=null??45;
 console.log(b);
 //??=
 const user={'name':'Gopal'};
 console.log(user);
 console.log(user.name);
 user.city??='Salem';
 user.city=null??'Salem';
 console.log(user.city);
 console.log(user);
*/

//Increment operator
let a=1;
a++;
console.log(a);
let b=5;
b--;
console.log(b);
//Postfix  Increament a++
// Prefix Increment ++b
let x=3;
const y=x++;
console.log(y);
console.log(x);

let i=3;
const j=i++;
console.log(j);
console.log(i);
console.log(j);
