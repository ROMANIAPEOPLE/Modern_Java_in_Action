package Stream.스트림기본;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class lowCal_java7 {

    public static void main(String[] args){
        List<Dish> menu = new ArrayList<>();
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish dish: menu) {
            if(dish.getCalories() < 400){
                lowCaloricDishes.add(dish);
            }
        }

        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(),o2.getCalories());
            }
        });

        List<String> lowCaloriName = new ArrayList<>();
        for(Dish dish : lowCaloricDishes) {
            lowCaloriName.add(dish.getName());
        }


    }


}
