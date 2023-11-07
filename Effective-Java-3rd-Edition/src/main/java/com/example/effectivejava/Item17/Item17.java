package com.example.effectivejava.Item17;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.BitSet;
import java.util.Date;

public class Item17 {
    public static void main(String[] args){
        // Immutable
        String name = new String("NAME");
        System.out.println(name.toLowerCase());//name
        System.out.println(name);//NAME

        // Mutable
        Date date = new Date();
        System.out.println(date);//Sat Nov 04 22:52:15 TRT 2023
        date.setDate(7);
        System.out.println(date);//Tue Nov 07 22:52:15 TRT 2023

	    // immutable
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);//2023-11-04
        System.out.println(localDate.plusDays(1));//2023-11-05
        System.out.println(localDate);//2023-11-04


        //The major disadvantage of immutable classes is that they require a separate object for each distinct value
        BigInteger fact = new BigInteger("1");
        System.out.println(fact); //1
        System.out.println(fact.hashCode()); //1
        fact = fact.flipBit(0);
        System.out.println(fact); //0
        System.out.println(fact.hashCode()); //0

        BitSet bits1 = new BitSet(1);
        System.out.println(bits1);//{}
        System.out.println(bits1.hashCode());//1234
        bits1.flip(0);
        System.out.println(bits1);//{0}
        System.out.println(bits1.hashCode());//1235

        //solution to disadvantage
        StringBuilder mutableString = new StringBuilder("now mutable");
        System.out.println(mutableString);//now mutable
        System.out.println(mutableString.hashCode());//769287236

        mutableString.setCharAt(7, '@');
        System.out.println(mutableString.toString());//now mut@ble
        System.out.println(mutableString.hashCode());//769287236

    }
}
