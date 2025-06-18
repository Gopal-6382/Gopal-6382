//Break Statement
    /*

for(let i=1;i<=10;i++)
    {
      console.log(i);
      if(i==5){
        break;
      }
    }
      */  

    //Continue Statement  or skip statement
    for(let i=1;i<=10;i++)
        {
          if(i==4){
            continue;
          }
          console.log(i);
        }
        
        
        for(let i=1;i<=10;i++)
        {
          if(i%2==0){
            continue;//that means skipp that conditon or else
          }
          console.log(i);
        }
    
console.log("------------------------------------")

for (let i=0;i<18;i++){
  if(i==8){
    continue;
  }
  else if(i==4){
    continue;
  }
  console.log(i);
}