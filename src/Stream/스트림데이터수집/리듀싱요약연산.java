package Stream.스트림데이터수집;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;

public class 리듀싱요약연산 {
    public static void main(String[] args) {
        //기존의 방법
        int totalCal = Dish.menu.stream().collect(Collectors.summingInt(Dish::getCalories));

        //리듀싱 요약연산
        int totalCal2 = Dish.menu.stream().collect(reducing(0, Dish::getCalories, (a,b) -> a+b));

        System.out.println(totalCal);
        System.out.println(totalCal2);


        //한개의 인수를 갖는 reducing
        Optional<Dish> mostCal = Dish.menu.stream().collect(reducing((d1,d2) -> d1.getCalories() > d2.getCalories() ? d1: d2));
        System.out.println(mostCal);

        //기존 요약 연산
        Comparator<Dish> comp = Comparator.comparing(Dish::getCalories);
        Optional<Dish> mostCal2 = Dish.menu.stream().collect(maxBy(comp));
        System.out.println(mostCal2);

    }
}
