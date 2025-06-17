package OOPS;

class Student {
    String name;
    int roll;

    Student(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    void display() {
        System.out.println(name + " " + roll);
    }
}

public class Array_Of_Object {
    public static void main(String[] args) {
        Student s1 = new Student("Raj", 101);
        Student s2 = new Student("Vijay", 102);
        System.out.println(s1.name + " " + s1.roll);
        Student st[] = new Student[5];
        st[0] = s1;
        st[1] = s2;
        st[2] = new Student("rem", 11);
        st[4] = new Student("Ra", 106);
        for (int i = 0; i < st.length; i++) {
            if(st[i]!=null){
            st[i].display();
        }else System.out.println("null");
    }
}}
