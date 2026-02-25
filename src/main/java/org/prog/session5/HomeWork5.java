package org.prog.session5;

public class HomeWork5 {

    String owner;
    int speed;

    public HomeWork5(String owner, int speed) {
        this.owner = owner;
        this.speed = speed;
    }

    public void goTo(String destination) {
        System.out.println("car owned by" + owner +
                " is going to " + destination +
                " at " + speed);
    }

    public static void main(String[] args) {
        HomeWork5 car = new HomeWork5("Emilia", 80);
        car.goTo("Paris");
    }
}
