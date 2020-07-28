package Stream.스트림데이터수집;

import java.util.Optional;
import java.util.OptionalInt;

import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summingInt;

public class 요약연산 {
    public static void main(String[] args) {
        //Dish의 총 칼로리 값 구하기
        int totalCal = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        //초기값을 받는 reduce로 총 칼로리 값 구하기
        int totalCal2 = Dish.menu.stream().map(t->t.getCalories()).reduce(0,(o1,o2) -> (o1+o2));
        //숫자형 스트림
       OptionalInt totalCal3 = Dish.menu.stream().mapToInt(t->t.getCalories()).reduce(Integer::sum);
       //숫자형 스트림
       int totalCal4 = Dish.menu.stream().mapToInt(t->t.getCalories()).sum();

       //초기값을 갖지 않는 reduce로 총 칼로리 값 구하기
       Optional<Integer> totalCal5 = Dish.menu.stream().map(t->t.getCalories()).reduce(Integer::sum);

        System.out.println(totalCal);
        System.out.println(totalCal2);
        System.out.println(totalCal3);
        System.out.println(totalCal4);
        System.out.println(totalCal5);

        double avgCal = Dish.menu.stream().collect(averagingDouble(Dish::getCalories));
        System.out.println(avgCal);


    }

}
