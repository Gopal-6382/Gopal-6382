
/*
function myFunction(first,second,...rest){//Rest parameter 
    console.log(first);
    console.log(second);
    console.log(rest);
}
myFunction(10,20,30,60,70,90);

//Spread operators
let myArray=[1,2,3];
let newArray=[...myArray,4,5,5,6,6];
console.log(newArray);

//
function Gopal({name,age=35}){
console.log(`Hello ${name}!`);
console.log(`Age ${age}!`);
}
const person={name:"Gopal",};//age:23};
Gopal(person);

const num1=[1,2,3,4];
function add([a,b,c,d]){
    return a*b+c*d;
}
console.log(add(num1));

const person07={name:'gopal',age1:30,city:'Salem',country:'india'};
function sayHello({name,age1,...gopal}){
    console.log(`hello ${name} !You are ${age1} years old`);
    console.log(gopal);
}
sayHello(person07);


function myCalling(){
    console.log("I am a call back function");
}
myCalling();
function test(gopal3){
    gopal3();//Call back fuction
}
test(myCalling);

//setTimeout(function,100);
setTimeout(function(){
console.log('Hello World');
},3000);

*/
setInterval(function () {
    console.log('Hello World');
}, 1000);

const num5 = [1, 2, 3];
    num5.forEach(function (num6) {
        console.log(num6);
    });