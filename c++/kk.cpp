#include<iostream>
using namespace std;
 class math{
 private:
     int a,b,c;
 public:
     math (){
     a=0;
     b=0;
     }
math(int x,int y)
    {
  a=x;
  b=y;
    }
    //Copy constructor
    math (math &x  ,math &y){
    a=x.a;
     b=y.b;
    }
 void sic()
 {
 c=a+b;
 cout<<"The value : "<<c<<endl;
 }
 };
 int main()
 {
     math o;
     math k(12,10);
     math o1(k);
     k.sic();
 o.sic();
  o1.sic();
     return 0;
 }
