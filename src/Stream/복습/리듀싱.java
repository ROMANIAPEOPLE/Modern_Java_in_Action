package Stream.복습;

import Stream.스트림데이터수집.Dish;

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

        Optional<Integer> maxValue4 = Dish.menu.stream().map(Dish::getCalories).reduce(Integer::max);


        /**
         * 1. Optional<T> 는 숫자 스트림으로 맵핑할 수 없다. 따라서 mapToInt는 사용 불가능.\
         * 2. 숫자 스트림으로 맵핑은 mapToInt, mapToDouble, , MapToLong 세 가지로, map과 동일한 기능을 수행하지만, Stream<T> 대신 특화된 스트림을 반환
         * 3. OptionalInt 와 같은 기본형 특화 스트림은 mapToInt와 함께 사용하고, max()와 min()을 호출할 수 있다.
         */

    }
}
