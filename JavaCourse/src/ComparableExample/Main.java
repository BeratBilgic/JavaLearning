package ComparableExample;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Book> books1 = new TreeSet<Book>();

        Book book1 = new Book("The Little Prince",302);
        Book book2 = new Book("The Alchemist",350);
        Book book3 = new Book("Lord of the Rings",520);
        Book book4 = new Book("Game of Thrones",850);
        Book book5 = new Book("Animal Farm",120);

        books1.add(book1);
        books1.add(book2);
        books1.add(book3);
        books1.add(book4);
        books1.add(book5);

        System.out.println("---Sorted by name---");

        for (Book book : books1) {
            System.out.println(book.getName() + " " + book.getPage());
        }

        System.out.println("\n---------------------------------------------\n");
        System.out.println("---Sorted by page---");


        TreeSet<Book> books2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPage() - o2.getPage();
            }
        });

        books2.add(book1);
        books2.add(book2);
        books2.add(book3);
        books2.add(book4);
        books2.add(book5);

        for (Book book : books2) {
            System.out.println(book.getName() + " " + book.getPage());
        }
    }
}
