package com.akon1994D.lambda;

import java.util.Iterator;
import java.util.function.Function;

/**
 * @author: whp
 * @description:
 * @date: 2019-7-16
 */
public class MapIterable<T,R> extends AbstractIterator<T,R> {
    Function<T,R> f;
    public MapIterable(Iterator<T> iterator, Function<T, R> f) {
        super(iterator);
        this.f = f;
    }

    @Override
    public boolean hasNext() {
       if(iterator.hasNext()){
           T next = iterator.next();
           R rf = f.apply(next);
           r = rf;
           hasTest= true;
           return true;
       }else{
           hasTest = true;
           r = null;
           return false;
       }
    }
}
