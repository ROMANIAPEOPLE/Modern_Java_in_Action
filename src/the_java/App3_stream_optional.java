package the_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Stream API2  , Optional
public class App3_stream_optional {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();

        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));


        Optional<OnlineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();


        //있으면 true, 없으면 false
        boolean present = spring.isPresent();
        System.out.println(present); //true.

        //만약 비어있다면, RUNTIME EXCEPTION이 발생함.
        OnlineClass onlineClass = spring.get();
        System.out.println(onlineClass.getTitle());

        //ifPresent : null 아니라면 실행
        spring.ifPresent(oc -> System.out.println(oc.getTitle()));

        //orElse : 만약 없으면 , 인스턴스(메소드) 실행
        //이미 만들어져있는 인스턴스를 사용할떄는 orElse가 적합.
        OnlineClass onlineClass1 = spring.orElse(createNewClass());

        //orElseGet(권장)
        OnlineClass onlineClass2 = spring.orElseGet(App3_stream_optional::createNewClass);

        //orElseThrow() : 없으면 그냥 에러를 던진다.
        OnlineClass onlineClass3 = spring.orElseThrow();




//        List<List<OnlineClass>> events = new ArrayList<>();
//        events.add(springClasses);
//        events.add(javaClasses);
//        //Stream 연습문제
//
//        System.out.println("spring 으로 시작하는 수업");
//        //TODO
//        springClasses.stream().filter(oc-> oc.getTitle().startsWith("spring")).forEach(oc-> System.out.println(oc.getId()));
//
//
//        System.out.println("close 되지 않은 수업");
//        //TODO
//        //1
//        springClasses.stream().filter(oc->oc.isClosed() == true).forEach(oc-> System.out.println(oc.getId()));
//        //2
//        springClasses.stream().filter(Predicate.not(OnlineClass::isClosed))
//                .forEach(oc-> System.out.println(oc.getId()));
//
//        System.out.println("수업 이름만 모아서 스트림 만들기");
//        //TODO
//        springClasses.stream().map(OnlineClass::getTitle).forEach(System.out::println);
//
//        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
//        //TODO
//
//        events.stream().flatMap(Collection::stream).forEach(oc-> System.out.println(oc.getTitle()));
//
//        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
//        //TODO
//        Stream.iterate(10, i->i+1).skip(10).limit(10).forEach(System.out::println);
//
//
//        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
//        //TODO
//
//        javaClasses.stream().anyMatch(oc->oc.getTitle().contains("Test"));
//
//        System.out.println("스프링 수업 중에 제목이 spring이 들어간 것만 모아서 List로 만들기");
//        //TODO
//        List<String> springClass= springClasses.stream().filter(oc->oc.getTitle().contains("spring")).map(OnlineClass::getTitle).collect(Collectors.toList());




    }
    private static OnlineClass createNewClass() {
        return new OnlineClass(10,"new class", false);

    }



}
