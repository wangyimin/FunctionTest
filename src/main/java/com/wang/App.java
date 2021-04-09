package com.wang;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        String[] arr = new String[]{"0", "1", "2", "3", "4"};

        Functions func = new Functions();
        System.out.println(func.convert("1", Integer.class));
        Stream.of(get(arr, func::filter)).forEach(System.out::print);
    }

    public static String[] get(String[] arr, Predicate<String> pred){
        return Stream.of(arr).filter(pred).collect(Collectors.toList()).toArray(new String[0]);
    }
}
