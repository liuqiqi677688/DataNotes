package cn.liuqiqi;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    @Test
    public void test1() {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("a");
        stringCollection.add("b");
        stringCollection.add("c");
        stringCollection.add("d");
        stringCollection.add("e");


        stringCollection
                .stream()
                .filter(e -> e.startsWith("a"))
                .collect(Collectors.toList()).forEach(System.out::println);

//        stringCollection
//                .stream()
//                .filter(e -> e.startsWith("a"))
//                .toList();
    }
}
