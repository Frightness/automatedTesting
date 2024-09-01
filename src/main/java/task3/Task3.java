package task3;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        // Array task:

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of array: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number of positions to rotate: ");
        int rotations = scanner.nextInt();

        for (int i = 0; i < rotations; i++) {
            int temporary = array[0];
            for (int j = 0; j < size - 1; j++) {
                array[j] = array[j + 1];
            }
            array[size - 1] = temporary;
        }

        System.out.println("Rotated array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }



        // LinkedList task:

        LinkedList<String> list = new LinkedList<>(Arrays.asList("hello", "world", "test"));

        System.out.println(list);

        list.addFirst("TestTest");

        System.out.println(list);

        list.addLast("Last");

        System.out.println(list);

        list.removeFirst();

        System.out.println(list);

        list.removeLast();

        System.out.println(list);

        list.stream().forEach(System.out::println);


//        V13.
//                Array Rotation: Write a Java program that takes an array of integers and rotates it by a given number of positions. Your program should prompt the user to enter the array size and the elements of the array, and then the number of positions to rotate the array. Finally, your program should output the rotated array.
//        Make LinkedList from the result array and perform the following operations: a) Add an element to the beginning of the list; b) Add an element to the end of the list; c) Remove the first element from the list; d) Remove the last element from the list; e) Print the elements of the list in reverse order;
//        Make up the situation for ArithmeticException. Catch it and display the explanation for your custom case.

    }
}
