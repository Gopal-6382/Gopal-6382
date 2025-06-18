#include<stdio.h>
union udemo{
int a;
char b;
};
int main(){
    printf("\nInteger : %d",sizeof(int));
    printf("\nChar      : %d,",sizeof(char));
    printf("\nSize of union %d",sizeof(union udemo));
return 0;
}

