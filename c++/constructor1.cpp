#include<iostream>
using namespace std;
 class math{
 private:
     int a,b,c;
 public:
math(int x,int y)
    {
 int a=x;
 int b=y;
    }
 void sic()
 {
 c=a+b;
 cout<<"The value : "<<c<<endl;
 }
 };
 int main()
 {
     math o(12,10);
     o.sic();
     return 0;
 }


 /*
class math{
private:
    int a,b,c;
public:
    void val(){
    a=9;
    b=9;
    }
    void add(){
    c=a+b;
    cout<<"Total : "<<c;
    }
};
 int main(){
     math o;
     o.add();
      o.val();
 return 0;
 }
 */
