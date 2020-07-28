package Stream.스트림활용;

import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class 연습문제 {
    public static void main(String[] args){

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("brian", "Cambridge");


        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian,2011,300),
                new Transaction(raoul,2012,1000),
                new Transaction(raoul,2011,400),
                new Transaction(mario,2012,710),
                new Transaction(mario,2012,700),
                new Transaction(alan,2012,950)
        );

        //2011년에 일어난 모든 트랜잭션을 찾아 값을 오름차순으로 정리하시오.
        List<Transaction> t2011 = transactions.stream().filter(i->i.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
        System.out.println(t2011);

        //2011년에 일어난 모든 트랜잭션을 찾아 값을 내림차순으로 정리하시오.
        List<Transaction> t2011_2 = transactions.stream().filter(i->i.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue).reversed()).collect(toList());
        System.out.println(t2011_2);

        //거래자가 근무하는 모든 도시를 중복 업이 나열하시오.
        List<String> city = transactions.stream().map(t-> t.getTrader().getCity()).distinct().collect(toList());
        System.out.println(city);

        //켐브릿지에서 근무하는 모든 거래자를 찾아서 이름 순으로 정렬하시오.
        List<Trader> names = transactions.stream().map(Transaction::getTrader).filter(t->t.getCity().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).distinct().collect(toList());
        System.out.println(names);

        List<Trader> namess = transactions.stream().map(Transaction::getTrader).filter(t->t.getName().equals("Cambridge")).sorted(Comparator.comparing(Trader::getName)).distinct().collect(toList());

        //밀라노에 근무자가 있는가?
        boolean milano = transactions.stream().anyMatch(t->t.getTrader().getCity().equals("Milan"));
        System.out.println(milano);

        //캠브릿지에 거주하는 거래자의 모든 트랜잭션 값을 출력

        List<Integer> CamList = transactions.stream().filter(t->t.getTrader().getCity().equals("Cambridge")).map(t->t.getValue()).collect(toList());

        System.out.println(CamList);

        //모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
        String traderStr = transactions.stream().map(t->t.getTrader().getName()).distinct().sorted().reduce("",(o1,o2) ->o1+o2);
        System.out.println(traderStr);

        //최대값을 구해라.
        Optional<Integer> max = transactions.stream().map(t->t.getValue()).reduce(Integer::max);
        System.out.println(max);

        //최소값을 구해라.
        Optional<Transaction> min = transactions.stream().reduce((o1,o2) -> o1.getValue()>o2.getValue() ? o2 : o1);
        System.out.println(min);


        Optional<Transaction> min2 = transactions.stream().min(Comparator.comparing(Transaction::getValue));
        System.out.println(min2);

        OptionalInt maxx = transactions.stream().mapToInt(Transaction::getValue).min();

        System.out.println(maxx);

    }
}
