//Looping Statement
/*
While looping 
while(condtion){
statmenet;
increment
}
 
let i = 1;
while (i <= 10) {
    console.log(i);
    i++;
}
for (let t = 0; t < arr.length; t++) {
    console.log(arr[t]);
}
    
let arr = ["ram", "sam", "ohm", "Sara", "Tiya"];
let u = prompt("enter the name");
let k = 0;
while (k < arr.length) {
    k++;
   if (u == arr[k]) {
    console.log("Yes");
}
}
*/

//Do while loop
/*
do{
statement
}
while(condition);
let table=88;limit=5;i=1;
do{
    console.log(table+"X"+i+"="+(table*i));
    i++;
}
while(i<=limit);
//For loop
for (let i = 1; i <= 10; i++) { 
    console.log(i); 
}
let arr=[];
for(let i=1;i<=100;i++){
    arr.push(i);
}
for(let i=1;i<=100;i++){
console.log(arr.pop);
}
console.log(arr);
//Nested for loop
let nums=[];
for(let i=0;i<3;i++){
     nums.push([]);
    for(let j=0;j<3;j++){
        nums[i].push(j);
    }
}
console.table(nums);
console.log(nums);

//For of loop
let names = ["ram", "sam", "ohm", "Sara", "Tiya"];
for(let i=0;i<names.length;i++){
    console.log(names[i]);
}
console.log("For of loop");
for(let name of names){
    console.log(name);
}

//For in loop used for json format
let  user={
    name:"Tutore joes",
    age:35,
    city:"salem",
    contact:"6387972585"
};
for (let prop in  user){
    console.log(prop+" : "+user [prop]);
}

let keys=Object.keys(user);
console.table(keys);
let values=Object.values(user);
console.table(values);
for(let i=0;i<values.length;i++){
    console.log(keys[i]+" : "+values[i]);
}
for(let i=0;i<keys.length;i++){
    console.log(keys[i]+" : "+values[i]);
    console.log(user[keys[i]]);
}
*/

/*
let arr = ["ram", "sam", "ohm", "Sara", "Tiya"];
let u = prompt("enter the name");
let k = 0;
while (k < arr.length) {
    if (u == arr[k]) {
        console.log("Yes");
    }
    else{
        console.log("NO");
    }
    k++;
}
*/

