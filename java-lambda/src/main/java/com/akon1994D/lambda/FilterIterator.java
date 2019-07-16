package com.akon1994D.lambda;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author: whp
 * @description:
 * @date: 2019-7-16
 */
public class FilterIterator<T> extends AbstractIterator<T,T> {

    private Predicate<T> p;

    public FilterIterator(Iterator<T> iterator, Predicate<T> p) {
        super(iterator);
        this.p = p;
    }

    @Override
    public boolean hasNext() {
        while (iterator.hasNext()){
            if(hasTest = p.test(r = iterator.next())){
                return true;
            }
        }
        hasTest = true;
        r = null;
        return false;
    }
}
