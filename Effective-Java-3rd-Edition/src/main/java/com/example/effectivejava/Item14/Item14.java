package com.example.effectivejava.Item14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Item14 {
    public static void main(String[] args){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("book 1", 100));
        books.add(new Book("book 2", 200));
        books.add(new Book("book 3", 50));

        Collections.sort(books);
        System.out.println(books); //[Book{name='book 3', page=50}, Book{name='book 1', page=100}, Book{name='book 2', page=200}]



        TreeSet<Book> bookTreeSet = new TreeSet<>();
        bookTreeSet.add(new Book("book 1", 100));
        bookTreeSet.add(new Book("book 2", 200));
        bookTreeSet.add(new Book("book 3", 50));
        System.out.println(bookTreeSet); //[Book{name='book 3', page=50}, Book{name='book 1', page=100}, Book{name='book 2', page=200}]



        ArrayList<Book> books2 = new ArrayList<>();
        books2.add(new Book("book 1", 100));
        books2.add(new Book("book 2", 200));
        books2.add(new Book("book 3", 50));

        NameComparator nameComparator = new NameComparator();
        Collections.sort(books2, nameComparator);
        System.out.println(books2); //[Book{name='book 1', page=100}, Book{name='book 2', page=200}, Book{name='book 3', page=50}]



        NavigableSet<PhoneNumber> s = new TreeSet<PhoneNumber>();
        for (int i = 0; i < 5; i++)
            s.add(PhoneNumber.randomPhoneNumber());
        System.out.println(s); //[043-764-3506, 185-406-6223, 527-079-3501, 603-172-0684, 748-955-7504]
    }
}
