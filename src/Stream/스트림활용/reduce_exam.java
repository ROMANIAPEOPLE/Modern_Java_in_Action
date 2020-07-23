package Stream.스트림활용;

import Stream.스트림기본.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//reduce를 활용한 예제

public class reduce_exam {
        public static void main(String[] args){
            int count = Dish.menu.stream().map(i->1).reduce(0,(a, b) -> (a+b));
            long count2 = Dish.menu.stream().count();
            System.out.println(count2);

            List<Integer> list = Arrays.asList(1,2,3,4,5,6);

            int sum = list.stream().reduce(0,Integer::sum);

            Optional<Integer> sum2 = list.stream().reduce((a,b) -> a+b);

            System.out.println("sum2 :" + sum2);
            Optional<Integer> min = list.stream().reduce(Integer::min);

            System.out.println(min);
            System.out.println(sum);


    }
}
