public class Main {
    // 3.
    public static int isTwinPaired(int[] a)
    {
        int preOdd = Integer.MIN_VALUE;
        int preEven = Integer.MIN_VALUE;

        for (int num: a) {
            if (num % 2 == 0) {
                if (preEven > num) {
                    return 0;
                }
                preEven = num;
            } else {
                if (preOdd > num) {
                    return 0;
                }
                preOdd = num;
            }
        }

        return 1;
    }

    // 2.
    public static int sameNumberOfFactors(int n1, int n2)
    {
        if (n1 < 0 || n2 < 0) {
            return -1;
        }

        if (n1 == 0 && n2 == 0) {
            return 1;
        }

        return countFactor(n1) == countFactor(n2) ? 1 : 0;
    }

    public static int countFactor(int num)
    {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    // 1.
    public static int hasNValues(int[] a, int n)
    {
        int[] uniqueValues = new int[a.length];
        int uniqueCount = 0;

        for (int value : a) {
            boolean found = false;

            for (int i = 0; i < uniqueCount; i++) {
                if (uniqueValues[i] == value) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                uniqueValues[uniqueCount] = value;
                uniqueCount++;
            }
        }

        return uniqueCount == n ? 1 : 0;
    }

    public static void main(String[] args) {
        // 3.
        System.out.println("isTwinPaired:");
        System.out.println(isTwinPaired(new int[]{-6, 12, 1, 24, 3, 5})); // 1
        System.out.println(isTwinPaired(new int[]{3, 2, 1}));             // 0
        System.out.println(isTwinPaired(new int[]{2, 4, 32}));            // 1
        System.out.println(isTwinPaired(new int[]{2, 2, 2, 1, 1, 1}));    // 1
        System.out.println(isTwinPaired(new int[]{1, 19, 23}));           // 1
        System.out.println(isTwinPaired(new int[]{1, 2}));                // 1
        System.out.println(isTwinPaired(new int[]{2, 1}));                // 1
        System.out.println(isTwinPaired(new int[]{8}));                   // 1
        System.out.println(isTwinPaired(new int[]{17}));                  // 1
        System.out.println(isTwinPaired(new int[]{}));                    // 1

        // 2.
        System.out.println("sameNumberOfFactors:");
        System.out.println(sameNumberOfFactors(-6, 21));  // -1
        System.out.println(sameNumberOfFactors(6, 21));   // 1
        System.out.println(sameNumberOfFactors(8, 12));   // 0
        System.out.println(sameNumberOfFactors(23, 97));  // 1
        System.out.println(sameNumberOfFactors(0, 1));    // 0
        System.out.println(sameNumberOfFactors(0, 0));    // 1

        // 1.
        int[] array1 = {1, 2, 2, 1};
        int[] array2 = {1, 1, 1, 8, 1, 1, 1, 3, 3};
        int[] array3 = {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10};
        System.out.println("hasNValues:");
        System.out.println(hasNValues(array1, 2));  // Output: 1
        System.out.println(hasNValues(array2, 3));  // Output: 1
        System.out.println(hasNValues(array3, 10)); // Output: 1
        System.out.println(hasNValues(array1, 3));  // Output: 0
        System.out.println(hasNValues(array2, 2));  // Output: 0
        System.out.println(hasNValues(array3, 20)); // Output: 0
    }
}