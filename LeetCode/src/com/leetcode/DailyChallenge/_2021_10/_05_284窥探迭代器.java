package com.leetcode.DailyChallenge._2021_10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class _05_284窥探迭代器 implements Iterator<Integer> {

    List<Integer> l = new ArrayList<>();
    int idx;
    int size;

    public _05_284窥探迭代器(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()) {
            l.add(iterator.next());
        }
        size = l.size();
        idx = -1;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return l.get(idx + 1);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        idx++;
        if (idx < size) {
            return l.get(idx);
        } else {
            return -1;
        }
    }

    @Override
    public boolean hasNext() {
        return idx < size - 1;
    }
}
