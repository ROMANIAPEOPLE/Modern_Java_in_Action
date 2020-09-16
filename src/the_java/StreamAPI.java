package the_java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("jkh");
        names.add("kms");
        names.add("kdb");
        names.add("KUD");

        List<String> collect = names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());

        collect.forEach(System.out::println);

        //원본은 바뀌지 않는다.
        names.forEach(System.out::println);



    }


}
