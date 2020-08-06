package Stream.복습;

import Stream.스트림기본.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class 검색과매칭 {
    public static void main(String[] args) {
        // 하나라도 true 인지 확인 하는 스트림

        boolean check = Dish.menu.stream().anyMatch(Dish::isVegetarian);
        System.out.println(check);

        //전부 false 인지 확인하는 스트림
        //전부 false면 true를 리턴하고, 그렇지 않으면 flase를 리턴한다.
        boolean check2  = Dish.menu.stream().noneMatch(Dish::isVegetarian);
        System.out.println(check2);

        //전부 true인지 확인하는 스트림
        //noneMatch와 반대 결과를 리턴한다.
        boolean check3 = Dish.menu.stream().allMatch(Dish::isVegetarian);
        System.out.println(check3);


        //소수 판별할때 noneMatch 사용하기.
        int n  = 97; // n이 소수인지 판별하려고 한다.
        boolean isPrime = IntStream.range(2,n).noneMatch(value -> n%value ==0);
        if(isPrime) System.out.println(n +"은 소수입니다.");
        else System.out.println(n +"은 소수가 아닙니다.");

        //소수 판별 효율성 UP ver
        int n2 = (int)Math.sqrt((double)n);
        boolean isPrime2 = IntStream.rangeClosed(2,n2).noneMatch(value -> n%value ==0);
        if(isPrime2) System.out.println(n +"은 소수입니다.");
        else System.out.println(n +"은 소수가 아닙니다.");


        //요소검색하는 스트림
        Optional<Dish> dish = Dish.menu.stream().filter(Dish::isVegetarian).findAny();
        System.out.println(dish);

        //isPresent는 값이 있으면 true로, 김문섭을 출력하고 값이 없다면 아무일도 일어나지 않는다.
       Dish.menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d-> System.out.println("김문섭"));

       //숫자 리스트에서 3으로 나누어 떨어지는 첫번째 제곱값을 반환하는 스트림 코드는?
        List<Integer> values = Arrays.asList(1,2,3,4,5);
        Optional<Integer> first = values.stream().map(n3->n3*n3).filter(n3->n3%3==0).findFirst();
        System.out.println(first);

    }
}
