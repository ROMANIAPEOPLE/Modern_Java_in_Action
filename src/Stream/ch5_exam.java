package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ch5_exam {
    public static void main(String[] args){
//        List<Integer> nums  = Arrays.asList(1,2,3,4,5);
//        List<Integer>  numsRes = nums.stream().map(i->i*i).collect(Collectors.toList());

        List<Integer> nums1 = Arrays.asList(1,2,3);
        List<Integer> nums2 = Arrays.asList(3,4);

        List<int[]> res = nums1.stream().flatMap(i -> nums2.stream().map(j->new int[]{i,j})).collect(Collectors.toList());

        System.out.println(res);




    }
}
