package Stream;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ch5_157 {
    public static void main(String[] args){
        List<Integer> number = Arrays.asList(1,2,3,1,3,3,2,4);
        number.stream().filter( i -> i%2 == 0).distinct().forEach(System.out::println);


        List<Dish> dishes = Dish.specialMenu.stream().filter(dish ->dish.getCalories() > 300).limit(3).collect(toList());
        System.out.println(dishes);

        List<Dish> meat = Dish.menu.stream().filter(d->d.getType() == Dish.Type.MEAT).limit(2).collect(toList());
        List<String> words = Arrays.asList("Modern" , "java" , "in" , "action");
        List<Integer> wordLengths = words.stream().map(String::length).collect(toList());
        System.out.println(wordLengths);

        List<Integer> dishNameLengths = Dish.menu.stream().map(Dish::getName).map(String::length).collect(toList());

        System.out.println(dishNameLengths);

        List<String> unique = words.stream().map(word -> word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
        System.out.println(unique);




    }
}
