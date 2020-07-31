package Stream.스트림데이터수집;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class 숫자를소수와비소수로분할 {
    public static void main(String[] args) {

        숫자를소수와비소수로분할 s = new 숫자를소수와비소수로분할();

        Map<Boolean, List<Integer>> map = s.partitionPrimes(50);
        System.out.println(map);


    }

    public boolean isPrime(int candidate){
        //소수 여부를 체크하는 스트림
        return IntStream.range(2,candidate).noneMatch(i->candidate % i == 0);
    }

    //조금 더 효율적인 방법을 . 소수의 대상을 주어진 수의 제곱근 이하의 수로 제한할 수 있다.
    public boolean isPrime2(int candidate){
        int candidateRoot = (int)Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2,candidateRoot).noneMatch(i->candidate%i ==0);
    }

    public  Map<Boolean, List<Integer>> partitionPrimes(int n){
        return IntStream.rangeClosed(2,n).boxed().collect(partitioningBy(c->isPrime2(c)));
    }



}
