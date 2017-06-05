package br.com.blz.java8lecture.stream;

import java.math.BigDecimal;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {

        //Stream.of(...)
        //[].stream()


        Stream<BigDecimal> limit = Stream.generate(() -> new BigDecimal("10.0")).limit(100);

        Stream<Integer> bigIntStream = Stream.iterate(0, n -> n + 10).limit(10);

        String sentence = "JavaScript é lento";
        Stream<String> wordStream = Pattern.compile("\\W").splitAsStream(sentence);
    }
}
