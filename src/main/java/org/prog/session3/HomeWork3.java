package org.prog.session3;

 public class HomeWork3 {

    public static void main(String[] args) {


        int[] myArrayToSort = {23, 7, 15, 2, 42, 9, 1};


        for (int value : myArrayToSort) {
            System.out.println(value);
        }

        System.out.println("==============");


        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < myArrayToSort.length - 1; i++) {
                if (myArrayToSort[i] > myArrayToSort[i + 1]) {
                    int temp = myArrayToSort[i];
                    myArrayToSort[i] = myArrayToSort[i + 1];
                    myArrayToSort[i + 1] = temp;
                    swapped = true;
                }
            }

        } while (swapped);


        for (int value : myArrayToSort) {
            System.out.println(value);
        }
    }
}