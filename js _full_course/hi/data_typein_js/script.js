//Data type in js
// js is dynamic programming
//primitive num,string,boolean,null,undefined,symbols 
//refrence array,object litrels,date

var a=25;
var b="gopal";
console.log(typeof a);
console.log(typeof b);
var isMarried=true;
console.log(typeof isMarried);
var p=null;
console.log(typeof p);
let v;
console.log(typeof v);
const s=Symbol();
console.log(s);
const o=Symbol()
console.log(o)
console.log(s===0)

var courses=['C','C++','Java'];
 var student={
    'name':'joes',
    'age':22
 }
 var d= Date();
console.log(d);
console.log(typeof courses);
console.log(typeof d);
console.log(student);
//type Conversion
// in console number color is red  string color violet
let ac;
ac=25.9;
console.log(ac,typeof ac);
a=String(a);
console.log(a,typeof a);
a=25.9;
console.log(a,typeof a);
a=a.toString();
console.log(a,typeof a);
/*
------------------------------*/

//STRING TO NUMBER
a="124";
a=Number(a);
console.log(a,typeof a);
//BOOLEAN TO NUMBER
b=true;
b=Number(b);
console.log(b,typeof b)
//ARRRAY TO STRING
c=[1,2,3,4,5];
console.log(c,typeof c);
c=String(c);
console.log(c,typeof c);
//not a number
c="gopal";
console.log(c,typeof c);
c=Number(c);
console.log(c,typeof c);
//can't show deimal value
c="9.7 8";
console.log(c,typeof c);
c=parseInt(c);
console.log(c,typeof c);

/*
1.we can convert types called type conversion 
2.can't covert letters
3.can't covert object like array value check in youtube
*/
//Type coercion
//this will not add the number it only concate the two string int type
 a="25";
 b=20;
console.log(a+b);

//first cover the string after we can add the string
a=Number(a);
console.log(a+b);