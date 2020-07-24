package Stream.스트림기본;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Person {
    int age;
    String name;
    // toString(), getter(), setter()...
    public Person(int age, String name){
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class 맵vs플랫맵 {

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(new Person(20,"kim"),
                new Person(21,"moon") , new Person(22,"sub"), new Person(23,"park"));

        list.stream().map(Person::getName).forEach(System.out::println);


        String[][] arrays = new String[][]{ {"a1", "a2"}, {"b1", "b2"}, {"c1", "c2", "c3"} };
        Stream<String[]> stream4 = Arrays.stream(arrays);
        Stream<String> stream5 = stream4.flatMap(s -> Arrays.stream(s));
        stream5.forEach(System.out::println);

        Arrays.stream(arrays).map(Arrays::stream).forEach(System.out::println);
        Arrays.stream(arrays).flatMap(Arrays::stream).forEach(System.out::println);


        String [] words = {"Hello", "KimMoonSUB"};


        Arrays.stream(words).map(t->t.split("")).flatMap(Arrays::stream).forEach(System.out::println);



    }




}
