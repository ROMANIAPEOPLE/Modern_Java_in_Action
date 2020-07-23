package Stream.스트림기본;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ch2_142 {

    public static void main(String[] args){
        List<String> highCal = new ArrayList<>();
        Iterator<Dish> it = Dish.menu.iterator();
        while(it.hasNext()) {
            Dish dish = it.next();
            if (dish.getCalories() > 300) {
                highCal.add(dish.getName());
            }
        }
        System.out.println(highCal);

        List<Dish> highCal2 = Dish.menu.stream().filter(dish -> dish.getCalories() >300).collect(toList());;

        System.out.println(highCal2);

    }

}
