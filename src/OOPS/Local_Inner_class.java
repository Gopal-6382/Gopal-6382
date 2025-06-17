package OOPS;
class Outercls{
    void display(){
        class Innercls{
            void display(){
                System.out.println("Inner class");
            }
        }
        System.out.println("Local inner class only call in inner class");
        Innercls obj=new Innercls();
        obj.display();
    }
}
public class Local_Inner_class {
    public static void main(String[] args) {
        Outercls obj=new Outercls();
        obj.display();
    }
}
