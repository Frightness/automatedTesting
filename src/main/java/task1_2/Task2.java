package task1_2;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};

        System.out.println("Елементи масиву:");
        for (int i : array) {
            System.out.println(i);
        }


        int count = 0;
        for (int i : array) {
            if (i % 2 != 0) {
                count++;
            }
        }

        System.out.println("Кількість непарних чисел: " + count);
    }
}


// V 13: Int Arrays
// Objective: To understand and use arrays with the int type in Java.
// Instructions:
// Declare and initialize an array of int.
// Use a for loop to print the elements of the array to the console.
// Use a for loop to find the number of odd in the array.
