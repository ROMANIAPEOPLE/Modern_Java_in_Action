package Stream;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ch5_162 {
    public static void main(String[] args){
        List<String> words = Arrays.asList("Hello","World");

//        List<String> res = words.stream().map(i->i.split("")).distinct().collect(toList());

        List<String> res = words.stream().map(i->i.split("")).flatMap(Arrays::stream).distinct().collect(toList());

        System.out.println(res);







    }
}
