#include<stdio.h>
int main(){
FILE *fp;
char c;
fp=fopen("fb.txt","r");
if(fp==NULL){
    printf("\n File can't open or file Not Found");
}
while(1){
    c=fgetc(fp);
    if(c==EOF)
        break;
    printf("%c",c);
}
return 0;
}
