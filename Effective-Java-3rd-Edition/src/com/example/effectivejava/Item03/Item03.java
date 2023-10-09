package com.example.effectivejava.Item03;

public class Item03 {
    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    // TODO: handle exception
                }

                System.out.println("HashCode of ElvisLazy: " + ElvisLazy.getInstance());
                System.out.println("HashCode of ElvisEager: " + ElvisEager.getInstance());
                System.out.println("HashCode of ElvisEnum: " + ElvisEnum.INSTANCE.hashCode());

            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                System.out.println("HashCode of ElvisLazy: " + ElvisLazy.getInstance());
                System.out.println("HashCode of ElvisEager: " + ElvisEager.getInstance());
                System.out.println("HashCode of ElvisEnum: " + ElvisEnum.INSTANCE.hashCode());

            }
        }).start();
    }
}
