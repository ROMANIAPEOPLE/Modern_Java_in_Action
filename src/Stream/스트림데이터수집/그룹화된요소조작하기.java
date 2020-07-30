package Stream.스트림데이터수집;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class 그룹화된요소조작하기 {
    public static void main(String[] args) {
        //500칼로리 넘는 요리만 필터하기(이전에 배웠던 내용을 기반으로)
        //이 방법은 key값 자체가 사라지는 문제가 있음.
        Map<Dish.Type , List<Dish>> caloricDishesType =
                Dish.menu.stream().filter(t->t.getCalories() >500).collect(groupingBy(Dish::getType));

        System.out.println(caloricDishesType);












    }
}
