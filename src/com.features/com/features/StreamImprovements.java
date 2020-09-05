package com.features;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamImprovements {

    public static void main(String[] args) {
        // Stream API Enhancements

        // takeWhile(Predicate)
        System.out.println("takeWhile ordered");
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8,9,10);
        stream.takeWhile(x -> x < 4).forEach(y -> System.out.println(y));

        // takeWhile(Predicate) unordered
        System.out.println("takeWhile unordered");
        Stream<Integer> stream1 = Stream.of(1,2,4,5,3,6,7,8,9,10);
        stream1.takeWhile(x -> x < 4).forEach(y -> System.out.println(y));

        // dropWhile(Predicate)
        System.out.println("dropWhile ordered");
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6,7,8,9,10);
        stream2.dropWhile(x -> x < 4).forEach(y -> System.out.println(y));

        // dropWhile(Predicate)
        System.out.println("dropWhile unordered");
        Stream<Integer> stream3 = Stream.of(1,2,4,5,3,6,7,8,9,10);
        stream3.dropWhile(x -> x < 4).forEach(y -> System.out.println(y));

        // iterate()
        System.out.println("iterate");
        IntStream.iterate(2, x -> x < 20, x -> x * x).forEach(System.out::println);

        // ofNullable(T t)
        System.out.println("ofNullable");
        Stream<Integer> stream4 = Stream.ofNullable(1);
        stream4.forEach(System.out::println);
    }

}
