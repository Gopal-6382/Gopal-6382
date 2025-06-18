#include<stdio.h>
struct demo{
double price;
union{
struct{
char *name;
char *author;
} book;
struct{
char *model;
char *color;
} cell;
}product;
}o2;
int main(){
    o2.product.cell.model="Nokia";
    o2.product.cell.color="Red";
    o2.price=7432.43;
    printf("\n model %s",o2.product.cell.model);
    printf("\n model %s",o2.product.cell.color);
    return 0;
}
