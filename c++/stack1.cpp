
#include<iostream.h>
using namespace std;
class Stack{
public int stack[100],top=-1,n,i,val;
for(i=0;i<top.length;i++){
    cin>>stack[i];
}
void push(int val){
    if(top=<100){
        cout<<"Stack is Overflow"<<endl;
    }
    else{
        stack[]=val;
    }
}
    void pop(){
    if(top==-1){
      cout<<"Stack is Underflow"<<endl;
    }
    else{
        cout<<stack[val]<<endl;
    }
       }
       void dispaly(){
       if(top==-1){
        cout<<"Stack is underflow";
       }
       else{
        for(i=0;i<top;i++){
            cout<<stack[i]<<endl;
        }
       }}
       };
       int main(){
       int val,option;
        cout<<"1.Push val in stack "<<endl;
       cout<<"1.Pop val in Stack "<<endl;
       cout<<"1. Display stack values"<<endl;
       cout<<"1.exit"<<endl;
       cin>>option;

     do{
         switch (option){
        case 1:
            cin>>val;
            push(int val);
        break;
         case 2:
             pop();
        break;
         case 3:
             dispaly();
        break;
         case 4:
             syst("cls");
        break;
         }

     }
     While(option=!4);
     getch();

       }

