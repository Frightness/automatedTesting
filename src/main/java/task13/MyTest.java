package task13;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({CustomTestListener.class, CustomExecutionListener.class, CustomInvokedMethodListener.class, CustomSuiteListener.class})
public class MyTest {

    @Test
    public void testMethod1() {
        System.out.println("Test method 1 executed.");
    }

    @Test
    public void testMethod2() {
        System.out.println("Test method 2 executed.");
    }
}
