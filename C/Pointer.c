#include<stdio.h>
int main(){
int a=10,*p;
int  ***r;
p=&a;
int **q;
printf("\nValue of A :%d",a);
printf("\nAddress of A :%d",&a);
printf("\nValue of P:%d",p);
printf("\nAddress of P :%d",&p);
printf("\nP Dereferencing :%d",*p);
printf("\n------------------------------------------------------");
q=&p;
printf("\nValue of P :%d",p);
printf("\nAddress of P :%d",&p);
printf("\nValue of P:%d",q);
printf("\nAddress of P :%d",&q);
printf("\nP Dereferencing :%d",**q);
printf("\n------------------------------------------------------");
r=&q;
printf("\nValue of P :%d",q);
printf("\nAddress of P :%d",&q);
printf("\nValue of P:%d",r);
printf("\nAddress of P :%d",&r);
printf("\nP Dereferencing :%d",***r);
int c=10;
int *k,*m;
k=&c;
m=k+1;
printf("\n Size of integer : %d",sizeof(c));
printf("\n Size of integer : %d",k);
printf("\n Size of integer : %d",*m);
return 0;
}
