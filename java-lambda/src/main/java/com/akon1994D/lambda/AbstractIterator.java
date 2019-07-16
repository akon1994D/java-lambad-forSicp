package com.akon1994D.lambda;

import java.util.Iterator;

/**
 * @author: whp
 * @description:
 * @date: 2019-7-16
 */
public abstract class AbstractIterator<T,R> implements Iterator<R> {
    protected Iterator<T> iterator;
    protected R r;
    protected boolean hasTest;

    public AbstractIterator(Iterator<T> iterator) {
        this.iterator = iterator;
        this.r = null;
        this.hasTest = false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public R next() {
        if(hasTest || hasNext()){
            hasTest = false;
            return r;
        }
        return null;
    }
}