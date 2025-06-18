/*
if(condition) 
-------------
let age=prompt("Enter your age:");
if(age!=null && age>18)
    console.log("you are elegible for vote");
*/
/*
if(conditon){
statement true
}
else{
statement false
}  
let age=prompt("Enter Your Age:");
if(age!=null && age>18){
    console.log("You are eligible for vote");
}
else{
    console.log("You are not eligible for vote");
}

/*
     if(conditon-1){
statement true
}
else if(condtion-2){
statment true
}
else{
statement false
}    

const mark=prompt("enter your mark");
if(mark<175){
    console.log("You are Fail");
}
else if(mark>=175 && mark<499){
    console.log("You are Pass");
}
else if(mark>500 && mark<549){
    console.log("You are B grade");
}
else if(mark>550 && mark<=600){
console.log("You are A grade");
}
else{
    console.log("Invalid mark");
}
*/

/* nested if Statement
/*
if(condition){
if(condition){
statement;
}
}

min mark >=35
91-100 A
81-90  B
71-80  C
D

let english = 95, tamil = 98, maths = 100;
let total, avg;
total = english + tamil + maths;
avg = total / 3;
console.log("Total" + total);
console.log("Avg" + avg.toFixed(2));
if ((english >= 35 && tamil >= 35 && maths >= 35) | avg>60) {
    console.log("Result : Pass");
    if (maths == 100) { console.log("Sentem in maths"); }
    else if ( avg == 97.67) {
        console.log("Grade : A Grade ");
    }
    else if (avg >= 80 && avg <= 90) {
        console.log("Grade : B Grade");
    }
    else if (avg > 70 && avg <= 80) {
        console.log("Grade : B Grade");
    }
    else {
        console.log("You are get average marks in this exam");
    }
} 
*/
/*
switch(choice){
    case choice:
    break;
    case choice:
    break;
    case choice:
    break;
    case choice:
    break;
    default:
        break;
    }
let num = 0;
switch (num) {
    case 1:
        console.log("hai");
        break;
    case 2:
        console.log("How");
        break;
    case 3:
        console.log("are");
        break;
    case 4:
        console.log("you");
        break;
    default:
        console.log("Invalid");
        break;
}
*/

/*
Combaining case statement
l
*/
let letter = 'a';

switch (letter) {
    case 'a':
    case 'e':
    case 'i':
    case 'o':
    case 'u':
    case 'A':
    case 'E':
    case 'I':
    case 'O':
    case 'U':
        console.log(letter + "  is a-n Vowel");
        break;
    default:
        console.log(letter + " is not a-n Vowel");
        break;
}
