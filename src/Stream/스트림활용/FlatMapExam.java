package Stream.스트림활용;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapExam
{
    public static void main(String[] args){

        String[][] namesArray = new String[][]{
                {"kim", "taeng"}, {"mad", "play"},
                {"kim", "mad"}, {"taeng", "play"}};

        Set<String> namesWithFlatMap = Arrays.stream(namesArray)
                .flatMap(i -> Arrays.stream(i))
                .filter(name -> name.length() > 3)
                .collect(Collectors.toSet());

        System.out.println(namesWithFlatMap);


        String [] arr = {"kim","taeng","mad","play","mads"};
        Set<String> names = Arrays.stream(arr)
                .filter(i -> i.length() >3)
                .collect(Collectors.toSet());


        System.out.println(names);


    }
}
