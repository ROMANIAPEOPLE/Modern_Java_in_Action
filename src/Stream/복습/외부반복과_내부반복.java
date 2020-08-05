package Stream.복습;
//컬렉션은 외부반복을 이용하며 , 스트림은 내부반복을 이용한다.


import Stream.스트림기본.Dish;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class 외부반복과_내부반복 {

    public static void main(String[] args) {

        //먼저, 자바7 컬렉션을 이용하여 400칼로리 미만인 음식을 담는 코드다.
        List<Dish> lowCal = new ArrayList<>();
        for(Dish dish : Dish.menu) {
            if(dish.getCalories() < 400) {
                lowCal.add(dish);
            }
        }

        //스트림으로 변환하면 ?

        List<Dish> lowCal2 = Dish.menu.stream().filter(c->c.getCalories() <400)
                .collect(Collectors.toList());

        System.out.println(lowCal);
        System.out.println(lowCal2);
        //결과는 모두 동일하다.


        //이번엔 위 코드를 자바7 기준으로 정렬해보자. (칼로리 오름차순)
        Collections.sort(lowCal, new Comparator<Dish>(){
            public int compare(Dish d1, Dish d2){
                return d1.getCalories() - d2.getCalories();
            }
        });
        System.out.println(lowCal);  //[season fruit, rice]


        // 람다로 정렬하기

        Collections.sort(lowCal2 , (d1,d2) -> d1.getCalories() - d2.getCalories());

        System.out.println(lowCal2); //[season fruit, rice]


        //스트림으로, 처음부터 필터링 한 후에 정렬하기

        List<Dish> res = Dish.menu.stream().filter(d->d.getCalories() <400).sorted(Comparator.comparing(Dish::getCalories)).collect(Collectors.toList());

        System.out.println(res);  //[season fruit, rice]

        //다음으로, 300칼로리가 넘는 음식 3개를 출력하는 코드를 자바7로 구현해보자.

        int i=0;

        List<String> threeHighCal = new ArrayList<>();
        for(Dish dish : Dish.menu) {
            if(i == 3) {
                break;
            }
            if(dish.getCalories() > 300){
                threeHighCal.add(dish.getName());
            }
            i++;
        }
        System.out.println(threeHighCal);


        //스트림으로!
        List<String> threeHighCalForStream = Dish.menu.stream().filter(d->d.getCalories() >300).map(Dish::getName).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCalForStream);

    }
}
