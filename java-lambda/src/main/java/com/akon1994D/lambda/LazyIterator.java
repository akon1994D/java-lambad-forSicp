package com.akon1994D.lambda;

import java.util.Iterator;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author: whp
 * @description:
 * @date: 2019-7-16
 */
public class LazyIterator<T> implements Iterator<T> {
    private T value;
    private Predicate<T> p;
    private Function<T,T> f;

    private Predicate<T> intiP;
    private T  intiValue;


    public LazyIterator(T intiValue, Predicate<T> p, Function<T, T> f) {
        this.value = intiValue;
        this.p = p;
        this.f = f;
        this.intiP = p;
        this.intiValue = intiValue;
    }

    @Override
    public boolean hasNext() {
        return p.test(value);
    }

    @Override
    public T next() {
        T r = value;
        T next = f.apply(value);
        this.value = next;
        return r;
    }
}
