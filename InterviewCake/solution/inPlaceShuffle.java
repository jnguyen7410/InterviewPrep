//https://www.interviewcake.com/question/java/shuffle?section=greedy&course=fc1

import java.util.Random;

private static Random rand = new Random();

private static int getRandom(int floor, int ceiling) {
    return rand.nextInt((ceiling - floor) + 1) + floor;
}

public static void shuffle(int[] theArray) {

    // if it's 1 or 0 items, just return
    if (theArray.length <= 1) {
        return;
    }

    // walk through from beginning to end
    for (int indexWeAreChoosingFor = 0;
        indexWeAreChoosingFor < theArray.length - 1; indexWeAreChoosingFor++) {

        // choose a random not-yet-placed item to place there
        // (could also be the item currently in that spot)
        // must be an item AFTER the current item, because the stuff
        // before has all already been placed
        int randomChoiceIndex = getRandom(indexWeAreChoosingFor, theArray.length - 1);

        // place our random choice in the spot by swapping
        if (randomChoiceIndex != indexWeAreChoosingFor) {
            int valueAtIndexWeChoseFor = theArray[indexWeAreChoosingFor];
            theArray[indexWeAreChoosingFor] = theArray[randomChoiceIndex];
            theArray[randomChoiceIndex] = valueAtIndexWeChoseFor;
        }
    }
}