public class MedianHunter {

    /**
     * Returns the median of the combined arrays {@code sortedArray1} and
     * {@code sortedArray2}
     * 
     * @param sortedArray1 the first sorted array
     * @param sortedArray2 the second sorted array
     * @return the median of the combined arrays.
     */
    public static double findMedian(int[] sortedArray1, int[] sortedArray2) {

        int size = sortedArray1.length;

        int iMin = 0;
        int iMax = sortedArray1.length - 1;
        int jMin = 0;
        int jMax = sortedArray2.length - 1;

        while (iMax - iMin > 1 && jMax - jMin > 1) {
            if ((size) % 2 == 0) {
                int iMid = (iMax + iMin) / 2;
                int jMid = (jMax + jMin) / 2;

                if (sortedArray1[iMid] < sortedArray2[jMid]) {
                    iMin = iMid;
                    jMax = jMid + 1;
                } else {
                    iMax = iMid + 1;
                    jMin = jMid;
                }
                size -= (iMid - iMin);

            } else {
                int iMid = (iMax + iMin) / 2;
                int jMid = (jMax + jMin) / 2;

                if (sortedArray1[iMid] < sortedArray2[jMid]) {
                    iMin = iMid;
                    jMax = jMid;
                } else {
                    iMax = iMid;
                    jMin = jMid;
                }
                size -= (iMid - iMin);
            }
        }

        int max;
        int min;

        if (sortedArray1[iMin] > sortedArray2[jMin]) {
            max = sortedArray1[iMin];
        } else {
            max = sortedArray2[jMin];
        }

        if (sortedArray1[iMax] < sortedArray2[jMax]) {
            min = sortedArray1[iMax];
        } else {
            min = sortedArray2[jMax];
        }
        return (max + min) / 2.0;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 4, 6, 8, 9, 10 };
        int[] arr2 = { 4, 5, 7, 8, 9, 11 };

        double median = MedianHunter.findMedian(arr1, arr2);

        System.out.println("The median of the combined arrays is: " + median);
    }
}