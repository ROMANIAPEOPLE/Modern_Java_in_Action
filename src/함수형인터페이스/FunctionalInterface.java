package 함수형인터페이스;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionalInterface {
    public static void main(String [] args){
        //ex) String 으로 받은 값을 Integer로 리턴할때
        final Function<String,Integer> toInt = v->Integer.parseInt(v);
        Integer nums = toInt.apply("102");

        final Consumer<String> print = v -> System.out.println(v);
        print.accept("김문섭");

        final Consumer<String> greeting = g-> System.out.println("Hello " + g);
        greeting.accept("김달섭");
    }
}
