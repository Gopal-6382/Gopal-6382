package OOPS;

import java.lang.Override;

abstract class Moblie {
    void VoiceCall() {
        System.out.println("You can Make voice Call");
    }

    abstract void camara();

    abstract void touchDisplay();
}

class samsung extends Moblie {

    @Override
    void camara() {
        System.out.println("16 mega Pixel camara");
    }

    @Override
    void touchDisplay() {
        System.out.println("5.5inch touch display");
    }
}

class Nokia extends Moblie {

    @Override
    void camara() {
        System.out.println("120mega Pixel camara");
    }

    @Override
    void touchDisplay() {
        System.out.println("6 inch touch display");
    }

    void fingerprint() {
        System.out.println("Finger print is enabled ");
    }
}

public class ABSTRACTDEMO2 {
    public static void main(String[] args) {
        samsung M32 = new samsung();
        M32.camara();
        M32.VoiceCall();
        M32.touchDisplay();
        Nokia M10 = new Nokia();
        System.out.println("The Mobile of Nokia features");
        M10.camara();
        M10.touchDisplay();
        M10.fingerprint();
        M10.VoiceCall();
    }
}
