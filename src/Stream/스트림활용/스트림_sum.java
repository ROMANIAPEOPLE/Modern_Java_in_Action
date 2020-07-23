package Stream.스트림활용;
//숫자형 스트림 활용
import Stream.스트림기본.Dish;

public class 스트림_sum {
    public static void main(String[] args){
        int sum = Dish.menu.stream().map(Dish::getCalories).reduce(0,Integer::sum);
        System.out.println(sum);

        int sum2 = Dish.menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(sum2);
    }
}
