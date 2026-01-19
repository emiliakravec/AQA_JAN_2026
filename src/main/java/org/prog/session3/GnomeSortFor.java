package org.prog.session3;

public class GnomeSortFor {

    public static void main(String[] args) {
        //5,2,7,8,10,1,9
        //2,5,7,8,10,1,9
        //2,5,7,8,1,10,9
        //2,5,7,1,8,10,9
        //2,5,1,7,8,10,9
        //2,1,5,7,8,10,9
        //1,2,5,7,8,10,9
        //1,2,5,7,8,9,10
        //array[4]
        //array[4 - 3]
        int[] array = new int[]{
                5,  //i = 0
                2,  //i = 1
                7,  //i = 2
                8,  //i = 3
                10, //i = 4
                1,  //i = 5
                9   //i = 6
        };

        for (int i = 0; i < array.length; ) {
            if (i != 0 && array[i] < array[i - 1]) {
                int current = array[i];
                array[i] = array[i - 1];
                array[i - 1] = current;
                i--;
            } else {
                i++;
            }
        }
    }
}