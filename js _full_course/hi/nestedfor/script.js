/*
let a=10;
 
//a=a+5; //+=
a+=5;//15
a*=5;//50
a%=5;//0
a-=5;//10
a/=5;//50

console.log(a);

let groups = [
    ["Ram", "Sam", "Ravi"],
    ["Kumar", "Tiya", "Sundar"],
    ["Rajesh", "Sara", "Rahul"],
  ];
  
  for(let group of groups)
  {
    inner:
    for(let member of group)
    {
      if(member.startsWith('R')){
        console.log("found one starting with R:", member);
        break inner;
      }
    }
  }
//Bitwise Operators in js

//&
let c=12;//1100
let b=24;//11000

console.log(a&c);

//&=
a&=c;
console.log(a);


// | (Bitwise or)
a=12;//1100
b=24;//11000
console.log(a|b);

//|=
a|=b;
console.log(a);


// ~    ~a = -a-1
k=25;  //-25-1=-26
console.log(~k);

// ^
a=12;
b=6;
console.log(a^b);

//<<
a=5;
b=2;
console.log(a<<b);
a<<=b;
console.log(a);

//>>
a=8;
b=2;
console.log(a>>b);
a>>=b;
console.log(a);

// >>>
a=-11;
b=2;



 //Nullish coalescing operator (??)

const a=null??'No Value';
console.log(a);

const b=null??45;
console.log(b);

//??=
const user={'name':'joes'};
console.log(user);
console.log(user.name);

user.city??='Salem';
console.log(user.city);
console.log(user);


*/

// Increment (++) or Decrement (--)

let a=1;
a++; //a=a+1
console.log(a);

let b=5;
b--; //b=b-1;
console.log(b);

/*
PostFix Increment   a++
Prefix Increment   ++a

let x=3;
const y=x++; //3

console.log("X : ",x,"Y : ",y);
console.log(y);


let i=3;
const j=++i;
console.log("I : ",i,"J : ",j);
console.log(j);


let english=95,tamil=98,maths=75;
let total,avg;
total=english+tamil+maths;
avg=total/3;
console.log("Total   : "+total);
console.log("Average : "+avg.toFixed(2));

if(english>=35 && tamil>=35 && maths>=35)
{
  console.log("Result  : Pass");
  if(avg>90 && avg<=100){
    console.log("Grade   : A Grade");
  }
  else if(avg>80 && avg<=90){
    console.log("Grade   : B Grade");
  }else if(avg>70 && avg<=80){
    console.log("Grade   : C Grade");
  }else{
    console.log("Grade   : D Grade");
  }
}
else
{
  console.log("Result  : Fail");
  console.log("Grade   : No Grade");
}

let num=5;

switch(num)
{
  case 1:
    console.log("One");
    break;
  case 2:
    console.log("Two");
    break;
  case 3:
    console.log("Three");
    break;
  default:
    console.log("Invalid Input");
    break;
}
 */
let letter='p';

switch(letter)
{
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
    console.log(letter+" is an Vowel");
    break;
  default:
    console.log(letter+" is not a Vowel");
    break;
}
let table=88;limit=-1;i=1;

do
{
  console.log(table+" X "+i+" = "+(table*i));
  i++;
}while(i<=limit);

let arr=[];
for(let i=1;i<=100;i++)
  {
    arr.push(i);
  }
  
  console.log(arr);

  let names = ["Tiya", "Ram", "Sam", "Raja", "Kumar"];

for(let i=0;i<names.length;i++)
{
  console.log(names[i]);
}
console.log("For of Loop : ")
for(let name of names){
  console.log(name);
}

let user = {
  name: "Tutor Joes",
  age: 35,
  city: "Salem",
  contact: "9043017689",
};

for(let pro in user)
{
  console.log(pro+" : "+user[pro]);
}