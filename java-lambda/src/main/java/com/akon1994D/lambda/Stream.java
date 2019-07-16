package com.akon1994D.lambda;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author: whp
 * @description:
 * @date: 2019-7-16
 */
public class Stream<T> implements Iterable<T>{

    public static <T> Stream<T> asStream(Iterable<T> iterable){
        Stream<T> tStream = new Stream<>();
        tStream.iterator = iterable.iterator();
        return tStream;
    }
    public static <T> Stream<T> asStream(Iterator<T> iterator){
        Stream<T> tStream = new Stream<>();
        tStream.iterator = iterator;
        return tStream;
    }
    public Stream<T> filter(Predicate<T> p){
        Iterator iterator = this.iterator;
        FilterIterator filterIterator = new FilterIterator<>(iterator, p);
        return asStream(filterIterator);
    }

    public <R> Stream<R> map(Function<T,R> f){
        MapIterable mapIterable = new MapIterable<>(this.iterator, f);
        return  asStream(mapIterable);
    }
    public <R> R reduce(BiFunction<T,R,R> accumulator, R init){
        Iterator<T> iterator = this.iterator;
        R r = init;
        while (iterator.hasNext()){
            r = accumulator.apply(iterator.next(), r);
        }
        return r;
    }
    public <T> Integer count(){
        return this.reduce((x,y)->y+1,0);
    }

    public static Iterable<Integer> range(Integer i){
        Predicate<Integer> p = x->x<i;
        Function<Integer,Integer> f=x->x+1;
        return () -> new LazyIterator<>(0, p, f);
    }


    public <R extends Collection<T>> R collect(Class<R> clazz){
        R r = null;
        try {
            r = clazz.newInstance();
            Iterator<T> it = this.iterator;
            while (it.hasNext()){
                r.add(it.next());
            }
            return r;
        } catch (InstantiationException |IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return this.iterator;
    }

    private Iterator iterator;
    private Stream(){}
}
