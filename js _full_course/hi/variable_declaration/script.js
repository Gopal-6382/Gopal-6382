//1.scope
//var can be print both inside and
//and outside of the scope

//let can be work work only inside the scope
// because, it act as private type not work outside of the scope

//const also let type 
if (true) {
  var msg = "welcome";
}
console.log(msg);
//var is the global scope data type 
//we can easily acess in all type scope;
//it act as public
if (true) {
  let hi = "welcome";
  console.log(hi);
}
//console.log(hi); 
// the let data type only print inside the scope 
// we can't print the value outside the scope 
// its act as private 
if (true) {
  const di = "welcome";
  console.log(di);
}
//  console.log(di); 
// this is not work const only work inside the scope
//-------   2 declaration   -----------------
// var a=12;
//console.log(a)

// using the var it can be only work 
//once after reuse variable reprint 
//var a=45;
//console.log(a)

//let a=12;
//console.log(a)
//using the let key word
// can't reasing the value 
//let a=12;

/* const a=12;
 console.log(a)
 
 //const a=12;
 */
//3.value assignment
/*
  var a=25;
  console.log(a);
  a=45;
  console.log(a);
  */
/*
let a = 25;
console.log(a);
a = 27;
console.log(a);

const a = 25;
console.log(a);
a = 27;//can't re'asign const error
console.log(a);
//we can be change the object values
const student = { 'name': "ram", "age": 12 };
console.table(student);
student.name = "joes";
console.table(student);
*/
