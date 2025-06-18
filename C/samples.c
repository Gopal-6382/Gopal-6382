#include<stdio.h>
 main(){
     /*
    char str[80];
    puts("Enter you name");
    gets(str);
    puts("Your name is:");
    puts(str);
    printf("%c",str[0]);
    */
    /*
    int num,absolute;
    printf("enter the signed number");
    scanf("%d",&num);
    absolute=(num<0)?-num:num;//-(-12)
    printf("%d",absolute);
    */
    /*
    int  feet,inch;
    float miles;
    printf("\nEnter Feet");
    scanf("%d",&feet);
    inch=feet*12;
    miles=(float)feet/5280;
    printf("\n%d feets is equal to %d inch",feet,inch);
    printf("and %f Miles ",miles);
    getch();
    */
    long int p;
    int n;
    float r,si;
    printf("\nEnter principle Amount ");
    scanf("%ld",&p);
    printf("/nEnter  rate of interest");
    scanf("%f",&r);
    printf("\nEnter periiiod ............:");
    scanf("%d",&n);
    si=p*n*r/100;
    printf("\n Interest Amount %f Rs.",si);
     }
