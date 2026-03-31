package org.prog.session8;

public class Android extends Phone {

    public Android(String model, String color) {
        super(model, color);
    }

    @Override
    public void call(String someone) {
        System.out.println("Android calling " + someone);
    }

    @Override
    public void unlockScreen() {
        System.out.println("Android unlocked");
    }
}
