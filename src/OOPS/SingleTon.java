package OOPS;

class ABC {
    static ABC obj = null;

    //private block the call in main function can't call this class becase block the private
    //also the ABC() is defalut contrucor when create the object the constructor will be call
    private ABC() {

    }

    public static ABC getInstance() {
        if (obj == null) {
            obj = new ABC();
        }
        return obj;

    }

    void diplay() {
        System.out.println("I am Display");
    }
}

public class SingleTon {
    public static void main(String[] args) {
        // Don't allow createing multilpe objects
        ABC o = ABC.getInstance();
        o.diplay();
    }
}
