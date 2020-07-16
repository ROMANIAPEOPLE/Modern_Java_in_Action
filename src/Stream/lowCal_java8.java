package Stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class lowCal_java8 {
    public static void main(String[] args){
        List<Dish> menu = new ArrayList<>();
        List<String> lowCaloricDishesName = menu.stream().filter(s ->s.getCalories() < 400)
                .sorted(comparing(Dish::getCalories)).map(Dish::getName).collect(Collectors.toList());

        //sorted : Dish 를 Calories 순으로 정렬함.
        //map : Nmae을 추출함
        //collect : toList , 즉 요소들을 List에 담음.

    }
}
