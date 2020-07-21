package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ch5_exam2 {
    public static void main(String[] args){
        List<Integer> numbers1 = Arrays.asList(1,2,3);
        List<Integer> numbers2 = Arrays.asList(3,4);

        List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j-> new int[] {i,j})).collect(toList());

        List<int[]> pairs3 = numbers1.stream().flatMap(i-> numbers2.stream().filter( j-> (i + j) % 3 ==0).map(j-> new int[]{i,j})).collect(toList());

        System.out.println(pairs);
     }
}
