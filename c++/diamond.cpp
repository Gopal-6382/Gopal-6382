#include<iostream>
using namespace std;
class a{
public:
    void display(){
    cout<<"Dispaly Method in A: "<<endl;
    }
};
class b: virtual public a{
    public:
   void show(){
    cout<<"Dispaly Method in B: "<<endl;
    }
};
class c:public a{
    public:
   void show2(){
    cout<<"Dispaly Method in B: "<<endl;
    }
};
class d:public b,public c{
    public:
   void show3(){
    cout<<"Dispaly Method in B: "<<endl;
    }
};

int main(){
d o;
o.display();
o.show();
o.show2();
o.show3();
return 0;
}
