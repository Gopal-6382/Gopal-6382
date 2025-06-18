#include<iostream>
using namespace std;
 class father{
 public:
     void c(){
     cout<<"Gopal krishnan "<<endl;
     }
  };
 class mother{
    public:
    void ug(){
  cout<<"hi "<<endl;
     }
 };

class son:public father ,public mother {
    public:
         void k(){
  cout<<"hoi "<<endl;
     }
 };

 int main(){
 son O;
 O.c();
 O.ug();
O .k();
 return 0;
 }




