package Stream.스트림데이터수집;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    }
}
