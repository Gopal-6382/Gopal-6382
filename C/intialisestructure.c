/*
#include<stdio.h>
struct student{
char *name;
 int age;
 float per;
};
/*
void display(struct student o){
     printf("\n Name :%s ",o.name);
    printf("\n Name :%d ",o.age);
    printf("\n Name :%f",o.per);
}
*/
/*
int main(){
struct student o[2];

o[0].name="Ram ";
o[0].age=25;
o[0].per=88.8;

o[1].name="kumar";
o[1].age=45;
o[1].per=77.8;

printf("\n-------------------------------------------------");
     printf("\n Name :%s ",o[0].name);
    printf("\n Name :%d ",o[0].age);
    printf("\n Name :%f",o[0].per);
    printf("\n-------------------------------------------------");
         printf("\n Name :%s ",o[1].name);
    printf("\n Name :%d ",o[1].age);
    printf("\n Name :%f",o[1].per);
    /*
    struct student o={"Gopal Krishnan",30,8`5.5};
    struct student *ptr=&o;
    o.name="Gopal Krishnan";
    o.age=30;
    o.per=85.5;
    printf("\n Name :%s ",(*ptr).name);
    printf("\n Name :%d ",ptr->age);
    printf("\n Name :%f",ptr->per);
//display(o);
return  0;
}
*/
#include<stdio.h>
struct student{
char *name;
int age;
float cgp;
};

int main(){
struct student o[2];
o[0].name="Gopal Krishnan";
o[0].age=27;
o[0].cgp=56.6;

o[1].name="ram";
o[1].age=20;
o[1].cgp=99.7;

printf("\n 1  %s",o[0].name);
printf("\n 1  %d",o[0].age);
printf("\n 1   %f",o[0].cgp);
printf("\n-----------------------------------------");
printf("\n-----------------------------------------");
printf("\n 1  %s",o[1].name);
printf("\n 1  %d",o[1].age);
printf("\n 1   %f",o[1].cgp);
}
