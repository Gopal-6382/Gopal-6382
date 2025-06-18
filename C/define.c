//Preprocessor Directives in C programming
#include<stdio.h>
#define LIMIT 5
#define MSG "GOPAL "
#define custom_kk(a)\
printf("\n"  #a" Welcome to our institution")
int main(){
for (int i=0;i<LIMIT;i++){
printf("\n%d",i);
}
printf("\n%s",MSG);
custom_kk("GOPAL   KRISHNAN");
printf("\nFile Name :   %s",__FILE__);
printf("\n Time :   %s",__TIME__);
printf("\nLINE :   %d",__LINE__);
return 0;
}
