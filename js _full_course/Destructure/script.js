let numbers=[10,20,30,40,50];
/*
//let a=numbers[0];
//let b=numbers[1];
//let c=numbers[2];
let [a,b,c,,d]=numbers;
console.log(a);
console.log(b);
console.log(c);
console.log(d);

let [a,b,...c]=numbers;//Balance 30,40,50 in c;
console.log(a);
console.log(b);
console.log(c);
*/
/*
let nestedArray=[[1,2],[3,4],[5,6]];
let[[a,b],[c,d],[e,f]]=nestedArray;
console.log(a);
console.log(b);
console.log(c);
console.log(d);
console.log(e);
console.log(f);

//Object 
let person={name:"Gopal",age:5,gender:"female"};
let {name,age,gender}=person;
console.log(name);
console.log(age);
console.log(gender);
*/

let address={
    street:"Cherry Road",
    city:"Salem",
    state:"Tamil Nadu",
    zip:"624453"
};
let employee={
    name:"Gopal",
    age:12,
    address
}
console.table(employee);

let {name,age,gender="Unknown",address:{street,city,state,zip}}=employee;
console.table(name);
console.table(age);
console.table(gender);
console.table(street);
console.table(city);
console.table(state);
console.table(zip);

