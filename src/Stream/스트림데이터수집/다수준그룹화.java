package Stream.스트림데이터수집;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

import static java.util.stream.Collectors.*;

public class 다수준그룹화 {
    public enum CaloricLevel {DIET, NORMAL, FAT}

    public static void main(String[] args) {

        Map<Dish.Type, Map<CaloricLevel, List<Dish>>> map = Dish.menu.stream().collect(groupingBy(Dish::getType
                , groupingBy(d -> {
                    if (d.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (d.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                })));

        // 서브 그룹으로 데이터 수집하기.

//        Map<Dish.Type, Long> map = Dish.menu.stream().collect(groupingBy(Dish::getType,counting()));

        Map<Dish.Type,Long> TypeCount = Dish.menu.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(TypeCount);
        System.out.println(map);


        //타입별로 칼로리가 가장 높은 값 반환하기
        Map<Dish.Type, Optional<Dish>> lowCalType = Dish.menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));

        System.out.println(lowCalType);


        //컬렉터의 결과를 다른 형식에 적용하기
        Map<Dish.Type, Dish> mostCaloricByType = Dish.menu.stream().collect(groupingBy(Dish::getType,
                collectingAndThen(
                        maxBy(Comparator.comparingInt(Dish::getCalories)),
                        Optional::get
                )));

        //groupingBy와 함께 사용하는 다른 컬렉터 예제 (타입별 칼로리의 합 구하기)
        Map<Dish.Type, Integer> sumCal = Dish.menu.stream().collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(sumCal);


        //채식요리 구하기
        Map<Boolean, List<Dish>> vegetarian =Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian));
        List<Dish> vegetarian2 = Dish.menu.stream().filter(d->d.isVegetarian()).collect(toList());

        System.out.println(vegetarian);
        System.out.println(vegetarian2);

        //채식,비채식 요리를 또 타입별로 분할
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarianDishesByType = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(
                Dish::getType
        )));

        System.out.println(vegetarianDishesByType);



        //채식,비채식 나누고 타입별로 요리 그룹화하기
        Map<Boolean, Map<Dish.Type , List<Dish>>> q1 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian
        ,groupingBy(Dish::getType)));
        System.out.println(q1);

        //채식,비채식 요리의 갯수
        Map<Boolean, Long> q2 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, counting()));
        System.out.println(q2);

        //채식,비채식 요리중 칼로리 500을 기준으로 나누기

        Map<Boolean, Map<Boolean, List<Dish>>> q3 = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                partitioningBy(d->d.getCalories() >500)));

        System.out.println(q3);

        //채식,비채식으로 분할 후 칼로리가 가장 높은 요리는?
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),Optional::get)));

        System.out.println(mostCaloricPartitionedByVegetarian);

    }

}
