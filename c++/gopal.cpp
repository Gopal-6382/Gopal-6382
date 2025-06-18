
#include<iostream>
#include<stdlib.h>
using namespace std;
class Stack{
	private:
		int top;
		int arr[5];
		public:
			Stack()
			{
				top=-1;
				for(int i=0;i<5;i++){

				arr[i]=0;
				}
			}
			bool isEmpty(){
				if(top==-1)
				return true;
				else
				return false;
			}
			bool isFull(){
				if(top==4)
				return true;
				else
				return false;
			}
			void push(int val){
				if(isFull()){
					cout<<"Stack Overflow"<<endl;
				}
				else
				{
					top++;//4
					arr[top]=val;
				}
			}
			int pop(){
				if(isEmpty()){
					cout<<"Stack underflow"<<endl;
					return 0;
				}
				else{
					int popValue=arr[top];
					arr[top]=0;
					top--;
					return popValue;
				}
			}
			int count(){
			return(top+1);
			}

			int peek(int pos){
				if(isEmpty()){
					cout<<"Stack underflow"<<endl;
				}
				else{
					return arr[pos];
				}
			}
			void change(int pos,int val){
				arr[pos]=val;
				cout<<"Value changed at location"<<pos<<endl;
			}
			void display(){
				if(top==-1){
					cout<<"Stack is underflow"<<endl;
				}
					else{
						cout<<"All values in the stack are"<<endl;
						for(int i=0;i<5;i++){
						cout<<"The element was"<<arr[i]<<endl;
					}
				}
			}

};
int main(){
	Stack s1;
	int option,postion,value;
	cout<<"What operation do you want to perform ? Select Option number,Enter 0 exit,"<<endl;
	cout<<"1.push"<<endl;
	cout<<"2.pop"<<endl;
	cout<<"3.isEmpty()"<<endl;
	cout<<"4.isFull()"<<endl;
	cout<<"5.peek()"<<endl;
	cout<<"6.count()"<<endl;
	cout<<"7.change()"<<endl;
	cout<<"8.display"<<endl;
	cout<<"9.clear screen"<<endl;
     cin>>option;
	 switch(option)	{
	 	case 1:
	 		cout<<"Enter the item to push in the stack"<<endl;
	 		cin>>value;
	 		s1.push(value);
	 		break;
	 		case 2:
	 			cout<<"This function is called = poped value"<<s1.pop()<<endl;
	 			break;
	 			case 3:
	 				if(s1.isEmpty())
	 				cout<<"Stack is Empty"<<endl;
	 				else
	 				cout<<"Stack is not Empty"<<endl;
	 				break;
	 				case 4:
	 					if(s1.isFull())
	 					cout<<"stack is full"<<endl;
	 					else
	 						cout<<"stack not  is full"<<endl;
	 						break;
	 				case 5:
	 					cout<<"Enter the position of item you want to peek "<<endl;
	 					cin>>postion;
	 					cout<<"Peek Function called"<<postion<<"is"<<s1.peek(postion)<<endl;
	 					break;
	 					case 6:
	 						cout<<"Count Function called - Number of items in the Stack are "<<s1.count()<<endl;
	 						break;
                      case 7:
					  cout<<"Change the function called,"<<endl;
					  cout<<"Enter postion of item you want to change";
					  cin>>postion;
					  cout<<endl;
					  cout<<"Enter value you want to change ";
					  cin>>value;
					  s1.change(postion,value);
					  break;
					  case 8:
					  	cout<<"Display Fuction called"<<endl;
					  	s1.display();
					  	break;
					  	case 9:
					  		system("cls");
					  		break;
					  	default:
					  		cout<<"Enter proper Option number"<<endl;
	 }

}

