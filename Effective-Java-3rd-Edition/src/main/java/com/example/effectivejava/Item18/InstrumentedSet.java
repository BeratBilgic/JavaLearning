package com.example.effectivejava.Item18;

import java.util.Collection;
import java.util.Set;

// Wrapper class - uses composition in place of inheritance
public class InstrumentedSet<E> {
    private final Set<E> set;
    private int addCount = 0;

    public InstrumentedSet(Set<E> set) {
        this.set = set;
    }

    public boolean add(E e) {
        addCount++;
        return set.add(e);
    }

    public boolean addAll(Collection<? extends E> c) { addCount += c.size();
        return set.addAll(c);
    }
    public int getAddCount() {
        return addCount;
    }
}
