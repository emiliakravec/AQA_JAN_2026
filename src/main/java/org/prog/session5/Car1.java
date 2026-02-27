package org.prog.session5;

public class Car1 {

        String owner;
        int speed;

        public Car1(String owner, int speed) {
            this.owner = owner;
            this.speed = speed;
        }

        public void goTo(String destination) {
            System.out.println("car owned by" + owner +
                    " is going to " + destination +
                    " at " + speed);
        }
}
