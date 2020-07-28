package Stream.스트림데이터수집;

import java.util.stream.Collectors;

public class 문자열연결하기 {
    public static void main(String[] args) {
        String shortMenu = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(shortMenu);

        String shortMenu2 = Dish.menu.stream().map(Dish::getName).collect(Collectors.joining(", "));
        System.out.println(shortMenu2);
    }
}
