#include<stdio.h>
#include<stdlib.h>
int * value()
{
    int a=10;
    return &a;
    }
    int main()    {
    const int k=10;
    printf("%d",k);
    //k++; Can't redeclare the variable because the const keyword
    int *ptr=NULL;
    ptr=value(); //&a
    printf("%d",*ptr);
    return 0;
    }
//Dangling Error
