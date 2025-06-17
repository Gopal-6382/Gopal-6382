package learn;

public class static_using_math {
    public static void main(String[] args) {
        System.out.println(Maths.power(5,20));
    }
}
class Maths{
    public static int power(int base,int power){
        int result=1;
        for(int i=1;i<=power;i++){
            result *=base;
        }
        return result;
    }


}
