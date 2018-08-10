//https://www.interviewcake.com/question/java/find-unique-int-among-duplicates?course=fc1&section=bit-manipulation

  public static int findUniqueDeliveryId(int[] deliveryIds) {

    int uniqueDeliveryId = 0;

    for (int deliveryId: deliveryIds) {
        uniqueDeliveryId ^= deliveryId;
    }

    return uniqueDeliveryId;
}