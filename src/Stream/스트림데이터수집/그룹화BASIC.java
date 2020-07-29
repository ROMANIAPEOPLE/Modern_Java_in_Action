package Stream.스트림데이터수집;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class 그룹화BASIC {
    public static void main(String[] args){

        List<Transaction> transactions = new ArrayList<>();
        Map<Currency, List<Transaction>> transactionByCurrencies = new HashMap<>();
        for(Transaction transaction : transactions){
            Currency currency = transaction.getCurrency();
            List<Transaction> list = transactionByCurrencies.get(currency);
            if(list == null){
                list = new ArrayList<>();
                transactionByCurrencies.put(currency,list);
            }
            list.add(transaction);
        }

        Map<Dish.Type, List<Dish>> dishesByType = new HashMap<>();
        for(Dish menus : Dish.menu){
            Dish.Type type = menus.getType();
            List<Dish> list = dishesByType.get(type);
            if(list == null){
                list = new ArrayList<>();
                dishesByType.put(type,list);
            }
            list.add(menus);
        }


        for(List<Dish> list : dishesByType.values()){
            System.out.println(list);
        }


        Map<Dish.Type, List<Dish>> dishesByTypeForStream = Dish.menu.stream().collect(groupingBy(Dish::getType));

        System.out.println(dishesByTypeForStream);




    }
}
