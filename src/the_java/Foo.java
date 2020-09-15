package the_java;

import java.sql.SQLOutput;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Foo {
    public static void main(String[] args) {
//        RunSomething runSomething = new RunSomething() {
//            @Override
//            public void doIi() {
//                System.out.println("HelloS");
//            }
//        };

        RunSomething runSomething = () -> System.out.println("hello");
        runSomething.doIi();


//        RunSuomething2 runSuomething2 = new RunSuomething2() {
//            @Override
//            public int doIt(int number) {
//               return number+10;
//            }
//        };

        RunSuomething2 runSuomething2 = (num) -> num+10;
        System.out.println(runSuomething2.doIt(10));


        Plus10 plus10 = new Plus10();
        System.out.println(plus10.apply(1));


        //바로 생성하여 람다로 사용할 수 있다.
        Function<Integer, Integer> pluss10 = (num) -> num+10;
        System.out.println(pluss10.apply(12));

        Function<Integer, Integer> multiply2 = (num) -> num*2;
        System.out.println(multiply2.apply(2));

        //compose안에있는 함수가 먼저 실행되고, 그다음 pluss10의 apply가 실행된다.
        Function<Integer,Integer> plusAndMultiply = pluss10.compose(multiply2);
        System.out.println("plusAndMultiply = " + plusAndMultiply.apply(2));

        System.out.println(pluss10.andThen(multiply2).apply(2));

        //Consumer : 입력값을 받아 출력하는 함수형 인터페이스
        Consumer<Integer> printT = (num) -> System.out.println(num);
        printT.accept(100);


        //Supplier : 입력값 없이 출력하는 함수형 인터페이스
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10);

        //predicate : 어떠한 인자값을 하나 받아서 true / false를 리턴해주는 함수형 인터페이스
        Predicate<String> startWithKH = (str) -> str.startsWith("K");
        System.out.println(startWithKH.test("sdsds"));

    }

    private void run(){
        int baseNumber=10;

        //로컬 클래스
        class LocalClass{
            void printVaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber);
            }
        }

        //익명 클래스
        Consumer<Integer> integerConsumer= new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        //람다
        Consumer<Integer> integerConsumer2 = (num) -> System.out.println(num);
        integerConsumer2.accept(baseNumber);
    }

}
