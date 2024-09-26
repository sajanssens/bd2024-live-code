package com.infosupport.streams;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StreamsDemo {

    public static void main(String[] args) {
        // NIET over IO-streams, maar over de Streams API
        // Since Java 8: Lambdas en Streams
        var integers = List.of(1, 2, 3, 4);

        // Stel: we willen alle even elementen met één ophogen, die tonen en daarvan de som bepalen.

        // Classic style
        var newList = new ArrayList<Integer>();
        int p = 0;
        for (Integer integer : integers) {
            p = integer;
            if (integer % 2 == 0) {
                p++;
                newList.add(p);
            }
        }

        // ok, I know, dit kan ook gecombineerd worden in bovenste loop:
        int som = 0;
        for (Integer i : newList) {
            som += i;
        }

        System.out.println(newList);
        System.out.println(som);

        // Dit kan ook met de Streams API:
        List<Integer> resultToo =                      // Stappen:
                integers.stream()                      // 1. create (1 keer)
                        .filter(i -> i % 2 == 0)       // 2. modify (0..* keer)
                        .map(i -> i + 1)               //
                        .toList();                     // 3. terminate (1 keer)

        System.out.println(resultToo);

        int sum =
                resultToo.stream()
                        .mapToInt(i -> i)
                        .sum();

        System.out.println(sum);

        // Groeperen gaat ook makkelijk:
        var ids = List.of(1, 1, 1, 2, 2, 3, 3, 3, 3);

        var countGroup = ids.stream()
                .collect(groupingBy(item -> item, counting()));
        System.out.println(countGroup);

        // Wat is flatMap?
        List<List<Integer>> lists = List.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3));

        lists.stream()
                .flatMap(list -> list.stream().map(i -> i * 2))
                // bovenstaande doet `map en flatten` (resultaat platslaan tot één stream)
                .forEach(System.out::println);
    }
}
