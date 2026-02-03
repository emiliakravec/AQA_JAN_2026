package org.prog.session2;

import java.awt.*;
import java.util.Random;

public class HomeWork2 {
    public static void main(String[] args) {

        Random random = new Random();

        while (true) {
            int i = random.nextInt(1000);
            int j = random.nextInt(1000);

            System.out.println("i = " + ", j = " + j);

            if ((i - j) % 7 == 0) {
                System.out.println("Break on (i - j) % 7 == 0");
                break;
            }
        }
    }

}
