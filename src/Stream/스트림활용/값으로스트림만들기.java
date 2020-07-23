package Stream.스트림활용;

import java.util.stream.Stream;

public class 값으로스트림만들기 {
    public static void main(String[] args){

        //스트림의 모든 문자열을 대문자로 변환한 후 문자열을 하나씩 출력한다.
        Stream<String> stream = Stream.of("Modern ","Java ","In ","Action ");
        stream.map(String::toUpperCase).forEach(System.out::println);

    }
}
