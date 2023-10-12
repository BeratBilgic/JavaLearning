package com.example.effectivejava.Item03;

//not Thread-safe
public class ElvisLazy {
    private static ElvisLazy instance;

    public ElvisLazy() {
    }

    public static ElvisLazy getInstance(){
        if(instance == null)
        {
            instance = new ElvisLazy();
        }
        return instance;
    }
}
