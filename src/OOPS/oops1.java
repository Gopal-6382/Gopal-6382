package OOPS;

public class oops1 {
    public static void main(String[] args) {
        Rect r=new Rect();
        Rect r2=new Rect();
        r.breadth=10;
        r2.breadth=10;
        r.length=20;
        r2.length=200;
        System.out.println(r.area());
        System.out.println(r2.area());
    }
}
class Rect{
    int length,breadth;
    void getDetails(int x,int y){
        length=x;
        breadth=y;
    }
    int area(){
        int a =length*breadth;
        return a;
    }
}