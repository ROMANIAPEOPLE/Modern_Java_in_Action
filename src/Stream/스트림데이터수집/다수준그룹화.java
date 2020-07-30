package Stream.스트림데이터수집;


import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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


    }

}
