package com.example.effectivejava.Item09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Item09 {
    private static final int BUFFER_SIZE = 0;

    public static void main(String[] args) throws IOException {
        /*
        The lesson is clear: Always use try-with-resources in preference to try-
        finally when working with resources that must be closed. The resulting code is
        shorter and clearer, and the exceptions that it generates are more useful. The try-
        with-resources statement makes it easy to write correct code using resources that
        must be closed, which was practically impossible using try-finally.
         */


        /*
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } finally {
            int data = 25 / 0;
            System.out.println("finally");
        }
         */


        /*
        try {
            int data = 25 / 0;
            System.out.println(data);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } finally {
            System.out.println("finally");
        }
         */

    }

    // try-finally - No longer the best way to close resources!
    static String firstLineOfFile1(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    // try-finally is ugly when used with more than one resource!
    static void copy1(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0)
                    out.write(buf, 0, n);
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    // try-with-resources - the the best way to close resources!
    static String firstLineOfFile2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // try-with-resources on multiple resources - short and sweet
    static void copy2(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0)
                out.write(buf, 0, n);
        }
    }

    // try-with-resources with a catch clause
    static String firstLineOfFile3(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }
}
