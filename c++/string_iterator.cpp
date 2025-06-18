#include<iostream>
using namespace std;
int main(){
string str="Tutore Joes";
string::iterator it;
for (it=str.begin();it!=str.end();it++)
cout<<*it<<endl;
cout<<"_______________________________________"<<endl;
string::reverse_iterator it2;
for (it2=str.rbegin();it2!=str.rend();it2++)
cout<<*it2<<endl;
return 0;
}
