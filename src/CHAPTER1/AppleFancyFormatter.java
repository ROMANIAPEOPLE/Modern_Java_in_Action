package CHAPTER1;

import java.sql.SQLOutput;
import java.util.List;

public class AppleFancyFormatter implements AppleFormatter {
    public String accept(Apple apple){
        String str = apple.getWeight() > 150 ? " heavy" : "light";
        return "A " + str + " " + apple.getColor() + " apple";
    }
}

class AppleSimpleFormatter implements AppleFormatter {
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
     }
}



