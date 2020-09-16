package the_java;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {

//        메서드 레퍼런스

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello= greeting::hello;

        UnaryOperator<String> hi = Greeting::hi;


        Function<String,Greeting> KHGreeting = Greeting::new;
        Greeting KH = KHGreeting.apply("JKH");


        Supplier<Greeting> greetingSupplier = Greeting::new;


        String [] arr = {"apple" , "banana", "strawberry"};
        Arrays.sort(arr, String::compareToIgnoreCase);


        Fooo fooo = new DefaultFoo("khh");
        fooo.printName();
        fooo.printNameUpperCase();

    }
}
