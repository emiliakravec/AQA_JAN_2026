package org.prog.session2;

import java.util.Random;

//TODO: write cycle where:
// - On each cycle generate random i and random j up to 1000
// - If (i - j) % 7 -> stop the cycle (use break)+

public class   Cycles {

    public static void main(String[] args) {
        for (int i = 10; i >= 0; ) {
            System.out.println(i);
        }

        int i = 0;
        Random random = new Random();
        while (true) {
            i = random.nextInt(1000);
            System.out.println(i);
            if (i % 19 == 0) {
                System.out.println("BREAK ON i%3 = 0");
                break;
            }
        }

        do {
            System.out.println(i);
        } while (i < 95);

        //i = 1; 1 <= 10 -> TRUE -> i++
        //i = 2; 2 <= 10 -> TRUE -> i++
        //i = 3
        //....
        //i = 9; 9 <= 10 -> TRUE -> i++
        //i = 10; 10 <= 10 -> TRUE -> i++
        //i = 11; 11 <= 10 -> FALSE -> END
    }
}
