#include<iostream>
using namespace std;
class math{
private:
    int a,b,c;
public:
    math(){
    a=10;
    b=20;
    }
    ~math(){
    cout<<"Destroyed";
    }
    void add(){
    c=a+b;
    cout<<"total : " << c<< endl;
    }
};
int main(){
math o;
o.add();
return 0;
}
