package Stream.복습;

import Stream.스트림기본.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class 필터링_맵핑 {
    public static void main(String[] args) {

        //1. Dish형 리스트에 담겨있는 (menu)들의 음식 이름의 길이 (length)를 구하는 스트림을 작성하기.
        List<Integer> lengthOfMenu = Dish.menu.stream().map(Dish::getName).map(String::length).collect(Collectors.toList());
        System.out.println(lengthOfMenu);

        //2. 중복된것을 제외할수있다.
        List<Integer> caloriesDistnct = Dish.menu.stream().map(Dish::getName).map(String::length).distinct().collect(Collectors.toList());
        System.out.println(caloriesDistnct);




    }
}
