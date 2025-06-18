#include<stdio.h>
void add();//Function declaration
int main(){
    //Function call
add();\
int a,b;
printf("\nEnter the A and B Values");
scanf("%d%d", &a, &b);
add2(a,b);
//add2(20,20);//Actual parameter
return 0;
}
void add(){//Without argumets
int a,b,c;
printf("\nEnter The Value of A & B :");
 scanf("%d %d",&a,&b);
 c=a+b;
 printf("\nTotal : %d",c);
}
void add2(int a , int b){//Formal Parameters also pass the parameters
int c;
 c=a*b;
 printf("\nTotal : %d",c);
}

