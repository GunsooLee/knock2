package main.java;

import java.math.BigDecimal;
import java.util.Random;

public class BoringJavaCode {
    public static void main(String[] args) {

        Object result;

        Integer randomNumber = new Random().nextInt(3);

        if(randomNumber == 1){
            result = new BigDecimal(30);
        } else {
            result = "hello";
        }
        System.out.println("Result is currently " + result);

        if( result instanceof BigDecimal){
            //add 47
            result = ((BigDecimal) result).add(new BigDecimal(47));
        } else {
            //put in into uppercase
            String tempResult = (String)result;
            result = tempResult.toUpperCase();
        }

        System.out.println("Result is currently " + result);

        String aa = "213213";


    }

}
