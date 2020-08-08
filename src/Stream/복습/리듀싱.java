package Stream.복습;

import Stream.스트림데이터수집.Dish;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class 리듀싱 {
    public static void main(String[] args) {
        List<Integer> numbers = asList(1,2,3,4,5,6);
        int sum =0;
        for(Integer i : numbers) {
            sum +=i;
        }
        System.out.println(sum);

        //1. 위 코드를 리듀싱을 이용한 스트림으로
        int sumOfStream = numbers.stream().reduce(0,(s1,s2)->(s1+s2));
        System.out.println(sumOfStream);
        //2. 초기값이 없는 스트림
        Optional<Integer> sumOfStream2 = numbers.stream().reduce((s3,s4) ->(s3+s4));
        System.out.println(sumOfStream2);

        //3. 2번과 완전 동일한 코드
        Optional<Integer> sumOfStream2_2 = numbers.stream().reduce(Integer::sum);
        System.out.println(sumOfStream2_2);


        //최댓값과 최솟값 구할때는 핈로 Optional 써야함, 왜냐? 없을수도 있으니까!

        Optional<Integer> maxValue = numbers.stream().reduce(Integer::max);
        System.out.println(maxValue);

        OptionalInt maxValue2 = Dish.menu.stream().mapToInt(Dish::getCalories).max();
        System.out.println(maxValue2);

        Optional<Integer> maxValue3 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::max);
        System.out.println(maxValue3);

        OptionalInt i = Dish.menu.stream().mapToInt(Dish::getCalories).min();



    }
}
