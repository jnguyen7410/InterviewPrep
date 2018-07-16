//https://www.interviewcake.com/question/java/shuffle?section=greedy&course=fc1

import java.util.Arrays;
import java.util.Random;

public class Solution {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] theArray) {
        if (theArray.length <= 1) {
            return;
        }
        
        int index1, index2;
        // shuffle the input in place
        for (int i = 0; i < theArray.length; i++) {
            do {
                index1 = getRandom(0, theArray.length - 1);
                index2 = getRandom(0, theArray.length - 1);
            }while (index1 == index2);
            
            int temp = theArray[index1];
            theArray[index1] = theArray[index2];
            theArray[index2] = temp;
        }

    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }
}