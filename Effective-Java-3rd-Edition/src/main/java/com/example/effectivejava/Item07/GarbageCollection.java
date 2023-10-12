package com.example.effectivejava.Item07;

public class GarbageCollection {
    protected void finalize() {
        System.out.println("garbage collector run");
    }


    public static void main(String[] args) {
        GarbageCollection ali = new GarbageCollection();
        GarbageCollection mehmet = new GarbageCollection();
        GarbageCollection sıla = new GarbageCollection();

        ali = null;

        sıla = mehmet;

        System.gc();
    }
}
