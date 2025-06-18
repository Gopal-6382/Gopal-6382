#include<iostream>
using namespace std;
int main(){
char marital,gender;
int age;
cout<<"\n Enter the marital M : Marrid ||  U :  Unmarrid";
cin>>marital;
if(marital=='M'  ||  marital=='m'){
    cout<<"You are Eligible"<<endl;
}
else{
 if(marital=='U'  ||  marital=='u'){
        cout<<"\n Enter the gender M : Male  F : Female"<<endl;
    cin>>gender;
    cout<<"\n Enter age "<<endl;
    cin>>age;
    }
     if((((gender=='m' || gender=='M')  && (30<=age))) || ((gender=='f' || gender=='F') && (25<=age)))
    {
     cout<<"You are Eligible"<<endl;
    }
   else{
    cout<<"\n You are not eligible";
    }
    }
    }
