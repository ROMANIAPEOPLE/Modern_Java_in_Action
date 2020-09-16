package the_java;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

//자바8 인터페이스 스태틱메소드
public class App2 {

    public static void main(String[] args) {
        List<String> name = new ArrayList<>();
    name.add("KH");
    name.add("MS");
    name.add("SOO");
    name.add("HJ");

    name.forEach(System.out::println);


        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("===================");
        while(spliterator1.tryAdvance(System.out::println));

        //K로 시작하는것을 제거하라.
        name.removeIf(s-> s.startsWith("k"));


        //Comparator 메소드
        Comparator<String> compareToIgnoreCase= String::compareToIgnoreCase;

        name.sort(compareToIgnoreCase.reversed());




    }


}
