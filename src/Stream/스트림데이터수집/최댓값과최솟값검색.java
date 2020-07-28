package Stream.스트림데이터수집;

import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.SortedMap;

import static java.util.stream.Collectors.maxBy;

public class 최댓값과최솟값검색 {
    public static void main(String[] args) {
        //1. Dish 요소를  가져오는 max값 구하기
        Comparator<Dish> dishCalComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxCal = Dish.menu.stream().collect(maxBy(dishCalComparator));

       // 가장 높은 칼로리의 value값 구하기.
        Optional<Integer> maxCal2 = Dish.menu.stream().map(t->t.getCalories()).reduce(Integer::max);

        // 가장 높은 칼로리의 value값 구하기2 .
        OptionalInt maxCal3  = Dish.menu.stream().mapToInt((Dish::getCalories)).max();

        System.out.println(maxCal + " , " + maxCal2 + " , " + maxCal3);
    }
}
