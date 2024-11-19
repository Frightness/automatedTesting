package task8;

public class Task8 {
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static int countOddNumbers(int[] array) {
        int count = 0;
        for (int i : array) {
            if (i % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static int[] getArray() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    public static void main(String[] args) {
        int[] array = getArray();
        printArray(array);
        int oddCount = countOddNumbers(array);
        System.out.println("Кількість непарних чисел: " + oddCount);
    }
}
