package OOPS;

import java.lang.Override;

interface camara {
    void click();

    void recording();
}

interface player {
    void play();

    void pause();

    void stop();

}

class phone extends Moblie implements player, camara {
    @Override
    void camara() {
        System.out.println("This is camara phone you can be take selfi and record vidio");
    }

    @Override
    void touchDisplay() {
        System.out.println("This Mobile is 6inch display wit touch");
    }

    @Override
    public void click() {
        System.out.println("You can take selfi via this ");
    }

    @Override
    public void recording() {
        System.out.println("You can take record vidio via this ");
    }

    @Override
    public void play() {
        System.out.println("You can  play music ");
    }

    @Override
    public void pause() {
        System.out.println("You can  pause music ");
    }

    @Override
    public void stop() {
        System.out.println("You can  stop music ");
    }
}

public class interfaceDemo2 {
    public static void main(String[] args) {
        phone p1 = new phone();
        p1.camara();
        p1.click();
        p1.recording();
        p1.play();
        p1.pause();
        p1.stop();
        p1.touchDisplay();
        p1.VoiceCall();

    }
}
