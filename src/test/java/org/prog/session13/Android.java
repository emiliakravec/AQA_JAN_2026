package org.prog.session13;

import java.util.Random;

public class Android {
    int modelNumber;

    public Android() {
        Random random = new Random();
        modelNumber = random.nextInt(5) + 1; // числа 1-5
    }

    public int getModelNumber() {
        return modelNumber;
    }
}
