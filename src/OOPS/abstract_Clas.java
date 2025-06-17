package OOPS;

import java.lang.Override;

abstract class abstract_class {
    abstract void abstract_method();

    void concrete_method() {
        System.out.println("concrete method");
    }
}

class concrete_class extends abstract_class {

    @Override
    void abstract_method() {
        System.out.println("abstract method");
    }
}

public class abstract_Clas {
    public static void main(String[] args) {
        abstract_class a = new concrete_class();
        a.abstract_method();
        a.concrete_method();
        concrete_class k=new concrete_class();
        k.abstract_method();
    }
}
