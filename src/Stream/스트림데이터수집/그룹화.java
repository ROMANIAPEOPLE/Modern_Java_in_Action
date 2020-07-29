package Stream.스트림데이터수집;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class 그룹화 {
    public static void main(String[] args) {
        Map<Dish.Type, List<Dish>> dishesByType = new HashMap<>();
        for (Dish dishes : Dish.menu) {
            Dish.Type type = dishes.getType();
            List<Dish> list = dishesByType.get(type);
            if (list == null) {
                list = new ArrayList<>();
                dishesByType.put(type, list);
            }
            list.add(dishes);
        }

        System.out.println(dishesByType);


        Map<Dish.Type, List<Dish>> dishesByTypeForStream = Dish.menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishesByTypeForStream);


    }
}
