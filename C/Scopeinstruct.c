#include<stdio.h>
#include<stdlib.h>
//This struct called global scope
struct student{
char *name;
int age;
float per;
};
void add(){
struct mark{//local Scope
int m1,m2,m3;
}s;
s.m1=50;
s.m2=50;
s.m3=50;
printf("\nMark-1  :  %d",s.m1);
printf("\nMark-2  :  %d",s.m2);
printf("\nMark-3  :  %d",s.m3);
}
int main(){
struct student o;
// you can't struct mark x;
o.name="Gopal Krishnan";
o.age=30;
o.per=85.5;
printf("\nName : %s",o.name);
printf("\nAge : %d",o.age);
printf("\nPer : %f",o.per);
add();
return 0;
}
