package Stream.스트림데이터수집;

import static java.util.stream.Collectors.reducing;

public class 컬렉션의유연성 {
    public static void main(String[] args) {
        int totalCal = Dish.menu.stream().collect(reducing(0,Dish::getCalories,Integer::sum));
        System.out.println(totalCal);

        int totalCal2 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println(totalCal2);

        int totalCal3 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCal3);
    }
}
