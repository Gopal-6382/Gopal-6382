let first_name="TuTor T ";
let last_name="Joes";

//Concatenation
let c=first_name+" "+last_name;
console.log("Concatenation : "+c);

//concat
c=first_name.concat(' : ',last_name);
console.log("Concat : "+c);

//append
c="Tutor ";
c+="  Joes";
console.log("Append : "+c);

//Escaping
c='She Can\'t run';
console.log(c);

//Length
c=first_name.length;
console.log("Length : "+c);

//Change Case
c=first_name.toUpperCase();
console.log("Uppercase : "+c);
c=first_name.toLowerCase();
console.log("Lowercase : "+c);

c=first_name.indexOf('T');
console.log("indexOf T : "+c);

c=first_name.lastIndexOf('T');
console.log("lastIndexOf T : "+c);

c=first_name.charAt(0);
console.log("charAt 1 : "+c);

c=first_name.charCodeAt(1);
console.log("charCodeAt 1 : "+c); 


c=first_name.substr(0,4);
console.log("substr : "+c);

//Substring
let text = "01234567890";
c=text.substring(0,4)
console.log("Substring : "+c);
c=text.substring(4);
console.log("Substring : "+c);
c=text.substring(4,0);
console.log("Substring : "+c);
c=text.substring(25,30);
console.log("substring Invalid Length : "+c);
c=text.substring(-543);
console.log("-34iot : "+c);
//Slice
c=text.slice(2,4);
console.log("slice : "+c);
c=text.slice(4,2);
console.log("slice : "+c);
c=text.slice(25,30);
console.log("slice Invalid Length : "+c);
c=text.slice(-5)
console.log("slice -5: "+c);

//Split in JS
let a="Tutor Joes Computer Education";
c=a.split();
console.log("Split :"+c);
console.table(c);

//replace in js
a="I am from Salem";
console.log("Before Replace : "+a);
c=a.replace('Salem','Chennai');
console.log("After Replace : "+c);

//includes in js
const pets = ['cat', 'dog', 'bat'];
console.log(pets.includes('cat'));
console.log(pets.includes('rat'));

//trim in js
a=" Joes ";
console.log("Before Trim : "+a.length);
a=a.trim();
console.log("After Trim : "+a.length);
console.log(a);

//padStart padEnd
a="5";
a=a.padStart(3,"hi");
console.log(a);

a="5";
a=a.padEnd(4,0);
console.log(a);

a="5";
a=a.padEnd(4,'$');
console.log(a);

//Long literal strings
//Method-1
let longString="C is a powerful general-purpose programming language"+
"developed at AT & T's Bell Laboratories of USA in 1972" +
"it was designed and written by Dennis Ritchie..";
console.log(longString);
//Method-2
longString = "C is a powerful general-purpose programming language \
developed at AT & T's Bell Laboratories of USA in 1972\
it was designed and written by Dennis Ritchie..";
console.log(longString);

//String.fromCharCode()
console.log(String.fromCharCode(65,67,68,97,98,122));


let first_name1="TuTor T ";
let last_name1="Joes";

console.log(first_name1+" "+last_name1);
a=first_name1.concat(last_name1);
console.log(a)

first_name1+=last_name;
console.log(first_name1);

k='hi can\'t avoid ';
console.log(k);

f=k.length;
console.log(f);
f1=k.toUpperCase();
console.log(f1);
console.log(k.indexOf('a'));
console.log(k.lastIndexOf('a'));

console.log(k.charAt(0));
console.log(k.charCodeAt(4));
console.log(last_name.substring(5,0))
console.log(k.substring(0,5))
console.log(k.substr(5))