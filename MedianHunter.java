/**
 * Represents a utility class to find the median of two sorted arrays.
 */
public class MedianHunter {

    /**
     * Returns the median of the combined arrays {@code sortedArray1} and
     * {@code sortedArray2}.
     *
     * @param sortedArray1 the first sorted array
     * @param sortedArray2 the second sorted array
     * @return the median of the combined arrays
     */
    public static double findMedian(int[] sortedArray1, int[] sortedArray2) {
        /*
         * Find the median of two sorted arrays using binary search
         */

        int m = sortedArray1.length;

        // Initialize variables for binary search
        int iMinimum = 0;
        int iMaximum = m;

        // Perform binary search
        while (iMinimum <= iMaximum) {
            int i = (iMinimum + iMaximum) / 2;
            int j = i;

            if (i < m && sortedArray2[j - 1] > sortedArray1[i]) {
                iMinimum = i + 1;
            } else if (i > 0 && sortedArray1[i - 1] > sortedArray2[j]) {
                iMaximum = i - 1;
            } else {
                int maxLeft = sortedArray2[j - 1];
                int minRight = sortedArray2[j];

                return (maxLeft + minRight) / 2.0;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6, 8, 9, 10 };
        int[] arr2 = { 4, 5, 7, 8, 9, 11 };

        double median = MedianHunter.findMedian(arr1, arr2);

        System.out.println("The median of the combined arrays is: " + median);
    }
}