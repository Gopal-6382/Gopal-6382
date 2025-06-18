if(true){
    let blockscope='I am a variable with local scope';
console.log(blockscope);
}

 
if(true){
    var global='I am a variable with global scope';
    console.log("good");
console.log(global);
}
console.log(global);


function myfunction(){
 myFunction='I am a varible with function scope';
 console.log(myFunction);
 function add(){
    console.log(myFunction);
 }
 add();
}
myfunction();
console.log(blockscope);
