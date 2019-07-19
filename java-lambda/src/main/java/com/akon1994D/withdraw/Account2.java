package com.akon1994D.withdraw;

import com.akon1994D.lambda.AbstractIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author: whp
 * @description:
 * @date: 2019-7-18
 */
public class Account2 {

    public static Iterable<Long> withDraw(long balance,Iterable<Long> amountStream){
        return ()->new Account2Iterator(amountStream.iterator(), balance);
    }

    static class Account2Iterator extends AbstractIterator<Long,Long> {
        public Account2Iterator(Iterator<Long> iterator,long balance) {
            super(iterator);
            r = balance;
        }
        @Override
        public boolean hasNext() {
            hasTest = true;
            if(iterator.hasNext() && r > 0){
                r =r- iterator.next();
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        long balance = 100;
        List<Long> amountStream = new ArrayList();
        amountStream.add(10L);
        amountStream.add(25L);
        amountStream.add(25L);
        Iterable<Long> iterable = Account2.withDraw(balance, amountStream);
        for (Long o : iterable) {
            System.out.println(o);
        }
    }
}
