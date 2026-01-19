package org.prog.session3;

public class GnomeSortWhile {

    public static void main(String[] args) {
        int i = 0;
        int[] array = new int[]{
                5,  //i = 0
                2,  //i = 1
                7,  //i = 2
                8,  //i = 3
                10, //i = 4
                1,  //i = 5
                9   //i = 6
        };

        while (i < array.length) {
            if (i != 0 && array[i] < array[i - 1]) {
                int current = array[i];
                array[i] = array[i - 1];
                array[i - 1] = current;
                i--;
            } else {
                i++;
            }
        }

        for (int j = 0; j < array.length; j++) {
            System.out.printf(array[j] + " ");
        }
    }
}
