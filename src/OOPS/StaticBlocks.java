package OOPS;

//Static blocks in java
class StaticBlock {
    static {
        System.out.println("Block-1");

    }

    static {
        System.out.println("Block-1");
    }
}

public class StaticBlocks {
    static {
        System.out.println("Block-1 Before main");
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println("Main");
    }

    static {
        System.out.println("Block-2 After main");
    }
}
