package OOPS;

public class MethodArgs {
    public static void getNames(String... names) {
        for (String name : names) {
            System.out.println(name );
        }
    }
    public static void main(String[] args) {
        getNames("Gopal","Krishnan","Raj","Ravi","Rcom");

    }
}