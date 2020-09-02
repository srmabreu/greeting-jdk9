package com.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionFactory {

    public static void main(String [] args) {
        // Factory Methods for Collections (JEP 269)
        // JDK 8
        List<String> citySC = new ArrayList<>();
        citySC.add("Florianópolis");
        citySC.add("São José");
        citySC = Collections.unmodifiableList(citySC);
//        citySC.add("Palhoça");
        citySC.stream().forEach(c -> System.out.println(c));

        // JDK 9 - Already immutable
        List<String> cityMG = List.of("Belo Horizonte", "Ouro Branco");
//        cityMG.add("Ouro Preto");
        cityMG.stream().forEach(c -> System.out.println(c));
    }

}
