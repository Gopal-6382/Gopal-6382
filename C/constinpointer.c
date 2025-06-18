#include<stdio.h>
#include<stdlib.h>
int main(){
char a[3]={'a','b','c'};
const char *p=a;
*p
printf("\n *p = %c ",*p);
/*
char a[3]={'a','b','c'};
const char *p=a;
printf("\n *p =  %c ",*p);
// This will not work because the pointer after mention after const *p='x';
p++;
printf("\n *p = %c ",*p);
Many of the problem give their so can check please value
*/
return 0;
}
