package org.prog.session3;

//TODO: Write bubble sort
//TODO: Fill array with random numbers *

public class BubbleSort {

    public static void main(String[] args) {
        //4,1,8,5,8,0,12,9
        //1,4,5,8,0,8,9,12
        //1,4,5,0,8,8,9,12
        //1,4,0,5,8,8,9,12
        //1,0,4,5,8,8,9,12
        //0,1,4,5,8,8,9,12
        //0,1,4,5,8,8,9,12 < DONE

        int[] myArrayToSort = new int[10];
        boolean condition = true;

        while (condition) {
            for (int i = 0; i < myArrayToSort.length; i++) {
                //if current element > next element > switch places
                //if switch happened -> condition = true
                //if no switch happened -> condition = false -> end sorting
            }
        }
    }
}
