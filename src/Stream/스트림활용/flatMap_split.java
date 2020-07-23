package Stream.스트림활용;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class flatMap_split {
    public static void main(String[] args){
        List<String> words = Arrays.asList("Hello","World");

//        List<String> res = words.stream().map(i->i.split("")).distinct().collect(toList());

        List<String> res = words.stream().map(i->i.split("")).flatMap(Arrays::stream).distinct().collect(toList());

        System.out.println(res);







    }
}
