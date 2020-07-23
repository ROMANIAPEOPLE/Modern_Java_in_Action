package Stream.스트림활용;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class 배열로스트림만들기 {
    public static void main(String[] args){
    //배열을 인수로 받는 정적 메서드 Arrays.stream을 이용해보자.
    int [] numbers = {2,3,5,7,11,13};
    int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }
}
