package com.features;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalEnhancement {

    public static void main(String[] args) {
        // Optional Class Enhancements

        // stream()
        Optional<String> opt = Optional.of("a");
        opt.stream().map(String::toUpperCase).forEach(op -> System.out.println("Option: Stream: " + op));

        // ifPresent(Consumer action)
        Optional<Integer> opt1 = division(4,2);
        opt1.ifPresent(x -> System.out.println("Option1: Result found = " + x));

        // ifPresentOrElse(Consumer action, Runnable emptyAction)
        Optional<Integer> opt2 = division(4,0);
        opt2.ifPresent(x -> System.out.println("Option2: Result found: " + x));

        System.out.println("Option2: Result not found, default value = " + opt2.orElse(0));

        // or(Supplier supplier)
        Optional<Integer> opt3 = division(4,0);
        Supplier<Optional<Integer>> sup = () -> Optional.of(-1);
        System.out.println("Option3: Result not found, return Optional - " + opt3.or(sup));
    }

    public static Optional<Integer> division(Integer i1, Integer i2) {
        if(i2 == 0) return Optional.empty();
        else {
            Integer i3 = i1/i2;
            return Optional.of(i3);
        }
    }

}
