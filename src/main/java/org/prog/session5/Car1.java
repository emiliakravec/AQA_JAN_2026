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

        public static void main(String[] args) {
            Car1 car = new Car1("Emilia", 80);
            car.goTo("Paris");
        }
}
