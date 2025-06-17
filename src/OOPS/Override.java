package OOPS;
class Base{
    String Employee;
    int roll;
    Base(String E,int r){
        this.Employee=E;
        this.roll=r;
    }
    void display(){
        System.out.println("The Employee name"+Employee);
        System.out.println("Their roll number is "+roll);
    }
}
class Derived extends Base{
    String Company;
    Derived(String E,int r,String c){
        super(E,r);
        Company=c;
    }
    void display(){
        System.out.println("The Employee name"+Employee);
        System.out.println("Their roll number is "+roll);
        System.out.println("Their company name is "+Company);
    }
}
public class Override {
    public static void main(String[] args) {
        Base b=new Base("Raj",101);
        Derived d=new Derived("Raj",101,"Rcom");
        d.display();
        System.out.println("**************************************************");
        b.display();
    }
}
