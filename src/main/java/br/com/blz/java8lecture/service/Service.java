package br.com.blz.java8lecture.service;

import java.util.function.Function;

import static br.com.blz.java8lecture.memoizer.Memoizer.memoize;

public interface Service {

    default <T, R> Function<T, R> memo(Function<T, R> fn) {
        return memoize(fn);
    }
}
