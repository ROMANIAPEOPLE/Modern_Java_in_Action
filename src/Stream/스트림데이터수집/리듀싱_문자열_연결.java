package Stream.스트림데이터수집;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.reducing;

public class 리듀싱_문자열_연결 {
    public static void main(String[] args) {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(joining());
        String shortMenu2 = Dish.menu.stream().map(Dish::getName).collect(reducing((s1,s2) -> (s1+s2))).get();
        String shortMenu3 = Dish.menu.stream().collect(reducing("",Dish::getName,(s1,s2)->s1+s2));

        System.out.println(shortMenu);
        System.out.println(shortMenu2);
        System.out.println(shortMenu3);
    }
}
