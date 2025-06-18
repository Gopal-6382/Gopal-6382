#include<stdio.h>
#include<stdlib.h>
int main(){
int i,n;
printf("\nEnter The Limit:");
scanf("%d",&n);
int *ptr=(int *)calloc(n,sizeof(int));
if(ptr==NULL){
    printf("Memory Not Avaible...");
    exit(1);
}
for(i=0;i<n;i++){
    printf("Enter the number");
    scanf("%d",ptr+i);
}
for(i=0;i<n;i++){
    printf("%d : %d \n",&ptr+i,*(ptr+i));
}
return 0;
}
