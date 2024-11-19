package task8;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task8Test {
    @Test(dataProvider = "arrayProvider")
    public void testCountOddNumbers(int[] array, int expectedOddCount) {
        int result = Task8.countOddNumbers(array);
        Assert.assertEquals(result, expectedOddCount, "Кількість непарних чисел повинна бути " + expectedOddCount);
    }

    @Test
    public void testGetArray() {
        int[] expected = {1, 2, 3, 4, 5, 6};
        int[] result = Task8.getArray();
        Assert.assertEquals(result, expected, "Масив повинен бути {1, 2, 3, 4, 5, 6}");
    }

    @Test
    public void testPrintArray() {
        int[] array = {1, 2, 3};
        Task8.printArray(array);
    }

    @DataProvider
    public Object[][] arrayProvider() {
        return new Object[][] {
                {new int[]{1, 2, 3, 4, 5, 6}, 3},
                {new int[]{1, 3, 5, 7, 9}, 5},
                {new int[]{2, 4, 6, 8}, 0}
        };
    }
}
