#include<iostream>
using namespace std;
/*
using namespace std;
enum gender {male,Female};
int main(){
    gender g=male;
    switch(g){
case male:
    cout<<"Gender Male";
    break;
case Female:
    cout<<"Gender Female";
    break;
default:
    cout<<" Invalid Gender ";
    break;
    }
using namespace std;
        class circle{
        private :
        float radius;
        public:
        float area(){
        cout <<"Enter The Radius"<<endl;
        cin>>radius;
        return (3.14*(radius*radius));
        }
        float circum()
        {
        return (2*3.14*radius);
        }
        };
        int main(){
        circle o;
        cout<<"Area of circle : "<<o.area()<<endl;
        cout<<"circum of circle:"<<o.circum()<<endl;
            */
            class student{
        private:
            string name;
            int age;
        public:
            void getdata(){
            cout<<"\n Enter Name &  Age :"<<endl;
            cin>>name;
            cin>>age;
            }
            void display(){
            cout<<"The name is  : "<<name<<endl;
            cout<<"The age is : " <<age<<endl;
            }
            };
            int main(){
            student o;
            o.getdata();
            o.display();
            cout<<"The name is  : "<<o.name<<endl;
            cout<<"The age is : " <<o.age<<endl;
            return 0;
            }
