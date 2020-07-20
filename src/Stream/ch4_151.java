package Stream;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ch4_151 {
    public static void main(String[] args){
        List<String> list = Dish.menu.stream()
                .filter(s-> {
                    System.out.println("filter :" + s.getName());
                    return s.getCalories() > 300;
                })
                .map(s ->{
                    System.out.println("mapping :" + s.getName());
                    return s.getName();
                }).limit(3)
                .collect(toList());

        System.out.println(list);
    }
}
