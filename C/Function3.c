#include<stdio.h>
/*
int add(int , int);
int main(){
    int a,b;
    printf("\nEnter the Value of A & b");
    scanf("%d%d", &a, &b);
    a=add(a,b);
    printf("\nTotal  :  %d,",a);
printf("\nFactorial : %d",fact(5));
    return 0;
}
int add(int x,int y){

    return x+y;
}

int fact(int i){
    if(i<=1){
        return i;
    }
    return i*fact(i-1);
}
*/
/*
void swap(int *x,int *y){
int temp;
temp=*x;
*x=*y;
*y=temp;
}
int main(){
    int a,b;
printf("\nEnter The value of A : B");
scanf("%d%d",&a,&b);
printf("\nBefore swap A:%d    |   B:%d",a,b);
swap(&a,&b);
printf("\nBefore swap A:%d    |   B:%d",a,b);
return 0;
}
*/
enum Bool{no,yes};
int main(){
enum Bool a;
enum point {x=20,y};
enum point b;
a=yes;
b=y;
printf("\na : %d",a);
printf("\nb : %d",b);

}
