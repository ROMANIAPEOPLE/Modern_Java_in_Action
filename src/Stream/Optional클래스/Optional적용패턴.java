package Stream.Optional클래스;

import Stream.스트림데이터수집.Dish;

import java.util.Optional;

public class Optional적용패턴 {
    public static void main(String[] args) {
        // 빈 Optional
        Optional<Car> optCar = Optional.empty();
        System.out.println(optCar);

        //null이 아닌 값으로 Optional 만들기
//        Optional<Car> optCar2 = Optional.of(car);

        //null 값으로 Optional 만들기
//        Optional<Car> optCar3 = Optional.ofNullable(car);

    }
}
