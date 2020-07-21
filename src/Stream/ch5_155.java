package Stream;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ch5_155 {
    public static void main(String[] args){
        List<Dish> vegetarianDishes = new ArrayList<>();
        for(Dish d : Dish.menu){
            if(d.isVegetarian()) {
                vegetarianDishes.add(d);
            }
        }


        List<Dish> vegetarianDishStream = Dish.menu.stream().filter(Dish::isVegetarian).collect(toList());

        System.out.println(vegetarianDishes);
        System.out.println(vegetarianDishStream);


    }
}
