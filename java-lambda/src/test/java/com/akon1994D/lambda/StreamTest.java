package com.akon1994D.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class StreamTest {

    @Test
    public void range() {
        Iterable<Integer> range = Stream.range(10);
        int i = 0;
        for (Integer integer : range) {
            assert integer==i;
            i++;
        }
    }

    @Test
    public void filter() {
        Iterable<Integer> range = Stream.range(10);
        Stream<Integer> filter = Stream.asStream(range).filter(x -> x % 2 == 0 && x != 0);
        int[] ints = new int[]{2,4,6,8};
        int index=0;
        for (Integer integer : filter) {
            assert  integer == ints[index];
            index++;
        }
    }

    @Test
    public void map() {
        Iterable<Integer> range = Stream.range(10);
        Stream<Integer> map = Stream.asStream(range)
                                    .filter(x -> x % 2 == 0 && x != 0)
                                    .map(x -> x * x);
        int[] ints = new int[]{4,16,36,64};
        int index=0;
        for (Integer integer : map) {
            assert  integer == ints[index];
            index++;
        }
    }

    @Test
    public void reduce() {
        Iterable<Integer> range = Stream.range(10);
        Integer sum = Stream.asStream(range)
                .filter(x -> x % 2 == 0 && x != 0)
                .map(x -> x * x)
                .reduce((x,y)->x+y,0 );
        assert sum == 120;
    }

    @Test
    public void count() {
        Iterable<Integer> range = Stream.range(10);
        Integer count = Stream.asStream(range)
                .filter(x -> x % 2 == 0 && x != 0)
                .map(x -> x * x)
                .count();
        assert count == 4;
    }

    @Test
    public void collect() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        HashSet<String> collect = Stream.asStream(list).map(x -> x + "hello")
                .collect(HashSet.class);

        assert collect.contains("1hello");
        assert collect.contains("2hello");
        assert collect.contains("3hello");
        assert collect.size() == 3;
    }
}