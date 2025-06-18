#include<stdio.h>

 typedef  struct student{
char *name;
int age;
float per;
} stud;
int main(){
    typedef int INTEGER;
    stud o;
//int a;
INTEGER a;
a=100;
printf("\n %d",a);
o.name="Gopal Krishnan";
o.age=30;
o.per=85.5;
printf("\nName : %s",o.name);
printf("\nAge : %d",o.age);
printf("\nPer : %f",o.per);
return 0;
}
