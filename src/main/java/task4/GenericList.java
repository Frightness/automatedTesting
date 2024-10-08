package task4;

import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
    private List<T> elements;

    public GenericList() {
        elements = new ArrayList<>();
    }

    public void addElement(T element) {
        elements.add(element);
    }

    public List<T> getElements() {
        return elements;
    }

    public static void main(String[] args) {
        GenericList<Integer> intList = new GenericList<>();
        intList.addElement(10);
        intList.addElement(20);
        System.out.println("Integer list: " + intList.getElements());

        GenericList<String> stringList = new GenericList<>();
        stringList.addElement("Hello");
        stringList.addElement("World");
        System.out.println("String list: " + stringList.getElements());
    }
}
