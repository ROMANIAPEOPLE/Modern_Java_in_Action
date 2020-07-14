package CHAPTER1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.add((new Apple("Red",150)));
        prettyPrintApple(inventory, new AppleFancyFormatter());
    }

    static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }


}
