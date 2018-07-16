//https://www.interviewcake.com/question/java/find-unique-int-among-duplicates?course=fc1&section=bit-manipulation

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int findUniqueDeliveryId(int[] deliveryIds) {

        if (deliveryIds == null) {
            throw new IllegalArgumentException();
        }
        if (deliveryIds.length == 1) {
            return deliveryIds[0];
        }
        // find the one unique ID in the array
        Set<Integer> idsFound = new HashSet<Integer>();
        
        for (int deliveryId : deliveryIds) {
            if (idsFound.contains(deliveryId)) {
                idsFound.remove(deliveryId);
            } else {
                idsFound.add(deliveryId);
            }
        }

        return (int) idsFound.toArray()[0];
    }


















    // tests

    @Test
    public void oneDroneTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesFirstTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {1, 2, 2});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdComesLastTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {3, 3, 2, 2, 1});
        assertEquals(expected, actual);
    }

    @Test
    public void uniqueIdInTheMiddleTest() {
        final int expected = 1;
        final int actual = findUniqueDeliveryId(new int[] {3, 2, 1, 2, 3});
        assertEquals(expected, actual);
    }

    @Test
    public void manyDronesTest() {
        final int expected = 8;
        final int actual = findUniqueDeliveryId(new int[] {2, 5, 4, 8, 6, 3, 1, 4, 2, 3, 6, 5, 1});
        assertEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}