#include<iostream>
using namespace std;
/*
    Default Constructor
    Parameterized Constructor
    Copy Constructor
*/
//Copy Constructor in C++ Programming

class math
{
private:
    int a,b,c;
public:
    math(int x,int y)
    {
        a=x;
        b=y;
    }
    math(math &x)
    {
        a=x.a;
        b=x.b;
    }
    void add()
    {
        c=a+b;
        cout<<"Total : "<<c<<endl;
    }
};
int main()
{
    math o(10,25);
    math o1(o);
    o.add();
    o1.add();
    return 0;
}
