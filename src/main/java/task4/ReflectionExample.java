package task4;

import java.lang.reflect.Method;

class CustomClass {
    public void printMessage() {
        System.out.println("This is a method in CustomClass.");
    }

    public int add(int a, int b) {
        return a + b;
    }

    private String secretMethod() {
        return "Secret method invoked!";
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            CustomClass customObj = new CustomClass();

            Class<?> customClass = customObj.getClass();

            Method[] methods = customClass.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName() + ", Return type: " + method.getReturnType());
            }

            Method methodToInvoke = customClass.getDeclaredMethod("secretMethod");

            methodToInvoke.setAccessible(true);

            Object result = methodToInvoke.invoke(customObj);
            System.out.println("Result of invoking secretMethod: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
