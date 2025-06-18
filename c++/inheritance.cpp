#include<iostream>
using namespace std;
 class mother{
 public :
     void amma(){
     cout<<"Amma the best"<endl;
     }
 class father:public mother{
   public:
       void father() {
       cout<<"Father also best"<endl;
       }
    };
    class son:public mother{
    public:
        void son(){
                 cout<<"Son is goat"<<endl;
                 }
    };
    int main(){
    son o;
    o.amma();
    o.father();
    o.son();
    }
