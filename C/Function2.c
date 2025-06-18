#include<stdio.h>

int main(){
int a;
a=add();
printf("\nTotal : %d",a);
return 0;
}

int add(){
    int a,b;
    scanf("%d%d",&a, &b);
    return a+b;
}
