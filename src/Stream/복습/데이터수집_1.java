package Stream.복습;

import Stream.스트림데이터수집.Dish;

import javax.swing.text.html.Option;
import java.util.*;

import static java.util.stream.Collectors.*;

public class 데이터수집_1 {

    public enum CaloricLevel {
        DIET , NORMAL , FAT
    }

    public static void main(String[] args) {

        //groupingBy  : map을 리턴
        Map<Dish.Type , List<Dish>> map = Dish.menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(map);

        //갯수를 세는 메서드
        long howMany = Dish.menu.stream().count();
        System.out.println(howMany);

        //스트림 값에서 가장 큰 값을 찾는 방법(객체형)
        Comparator<Dish> dishCalCom = Comparator.comparingInt(Dish::getCalories);

        Optional<Dish> maxValue = Dish.menu.stream().collect(maxBy(dishCalCom));
        System.out.println(maxValue.get().getCalories());
        System.out.println(maxValue);

        Optional<Dish> minValue = Dish.menu.stream().collect(minBy((dishCalCom)));
        System.out.println(minValue.get().getCalories());
        System.out.println(minValue);

        //summingInt와  sum

        int CalSum = Dish.menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(CalSum);
        int CalSum2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(CalSum2);

        double avg = Dish.menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avg);

        //문자열 연결하는 조이닝
        String words = Dish.menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(words);

        //reduce(Integer :: sum) 은 Optional을 반환한다.

        int totalCal = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        Optional<Integer> totalCal2 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum);
        System.out.println(totalCal);
        System.out.println(totalCal2);


        //칼로리에 따라 레벨을 분류해서 그룹핑하는 스트림
//        Map<CaloricLevel, List<Dish>> map2 = Dish.menu.stream().collect(groupingBy(d -> {
//            if(d.getCalories() <= 400) return CaloricLevel.DIET;
//            else if(d.getCalories() <=700) return CaloricLevel.NORMAL;
//            else return CaloricLevel.FAT;
//        }));

        Map<CaloricLevel, List<Dish>> map2 = Dish.menu.stream().collect(groupingBy(d-> {
            if(d.getCalories() <=400) return CaloricLevel.DIET;
            else if(d.getCalories() <=700) return CaloricLevel.NORMAL;
            else return CaloricLevel.FAT;
        }));

        //그룹핑에도 필터링 적용할 수 있음.
        Map<Dish.Type, List<Dish>> map3 = Dish.menu.stream().filter(d->d.getCalories() >=400).collect(groupingBy(Dish::getType));
        System.out.println(map3);






    }
}
