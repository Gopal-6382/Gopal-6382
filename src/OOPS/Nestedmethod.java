package OOPS;

class Outer {
    private int a, b;

    Outer(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int large() {
        if (a > b) {
            return a;
        } else return b;
    }

    int  display() {
        int l=large();
        return l;
    }
}

public class Nestedmethod {
    public static void main(String[] args) {
        Outer o = new Outer(10, 20);

        System.out.print("The greatest numbers is "+ o.display());
    }
}
/*
package OOPS;

// Demonstrating various nested method-related concepts
public class NestedMethodExamples {

    // ❌ Method inside method - NOT ALLOWED
    // Uncommenting this will cause a compile-time error
    /*
    void outer() {
        void inner() {
            System.out.println("Inner method"); // ❌ Not allowed
        }
    }

// ✅ Recommended approach — define both methods separately
void outerMethod() {
    System.out.println("Calling inner method from outer:");
    innerMethod();
}

void innerMethod() {
    System.out.println("✔ Inner method executed.");
}

// ✅ Class inside method — Local Inner Class
void otpValidation(int otp) {
    class Validator {
        boolean isValid(int value) {
            return value == 123456;
        }
    }

    Validator v = new Validator();
    if (v.isValid(otp)) {
        System.out.println("✔ OTP Verified Successfully.");
    } else {
        System.out.println("❌ Invalid OTP.");
    }
}

// ✅ Lambda Expression Example with Functional Interface
@FunctionalInterface
interface Greet {
    void sayHello(String name);
}

void useLambda() {
    Greet greet = (name) -> {
        System.out.println("👋 Hello, " + name);
    };
    greet.sayHello("Gopalakrishnan");
}

// ✅ Lambda with Runnable
void runThreadWithLambda() {
    Runnable r = () -> {
        System.out.println("🔄 Thread is running via Lambda");
    };
    new Thread(r).start();
}

public static void main(String[] args) {
    NestedMethodExamples ex = new NestedMethodExamples();

    // 1. Calling separate methods
    System.out.println("\n=== Separate Methods ===");
    ex.outerMethod();

    // 2. Local inner class
    System.out.println("\n=== Local Inner Class ===");
    ex.otpValidation(123456); // Try changing to wrong OTP to test

    // 3. Lambda with Functional Interface
    System.out.println("\n=== Lambda Expression (Greet) ===");
    ex.useLambda();

    // 4. Lambda with Runnable (Thread)
    System.out.println("\n=== Lambda with Runnable ===");
    ex.runThreadWithLambda();
}
}

 */
