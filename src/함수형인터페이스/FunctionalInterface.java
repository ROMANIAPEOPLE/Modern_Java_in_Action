package 함수형인터페이스;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static javafx.scene.input.KeyCode.T;

public class FunctionalInterface {
    public static void main(String [] args){
        //Function<T,R>  // apply 구현 R  리턴
        //ex) String 으로 받은 값을 Integer로 리턴할때
        final Function<String,Integer> toInt = v->Integer.parseInt(v);
        Integer nums = toInt.apply("102");

        //Consumer<T>  리턴값 없음. accept 구현
        final Consumer<String> print = v -> System.out.println(v);
        print.accept("김문섭");

        final Consumer<String> greeting = g-> System.out.println("Hello " + g);
        greeting.accept("김달섭");


        //Predicate<T>  // test 구현 , boolean 리턴
        List<Integer> numbers = Arrays.asList(-3,-2,-1,0,1,2,3);
        Predicate<Integer> 양수 = p -> p>0;
        List<Integer> list = new ArrayList<>();
        for(Integer num : numbers){
            if(양수.test(num)){
                list.add(num);
            }
        }

        List<Integer> res = filter(numbers, i -> i>0);

        System.out.println(res);

    }
    private static <T> List<T> filter(List<T> list ,Predicate<T> filter){
        List<T> res = new ArrayList<>();
        for(T input : list) {
            if(filter.test(input)){
                res.add(input);
            }
        }

        return res;
    }

}
