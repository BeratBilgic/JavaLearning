package BookStreamExample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Book book1=new Book("İnci",120,"John Steinbeck", LocalDate.of(2000,04,07));
        Book book2=new Book("Ateş ve Kan",800,"George R. R. Martin",LocalDate.of(2020,05,12));
        Book book3=new Book("Yılkı Atı",95,"Peyami Safa",LocalDate.of(1977,12,12));
        Book book4=new Book("Sol Ayağım",89,"Christy Brown",LocalDate.of(1985,04,25));
        Book book5=new Book("Yıldız Gemisi",125,"Brian Aldiss",LocalDate.of(1954,8,11));
        Book book6=new Book("Yabancı",90,"Albert Camus",LocalDate.of(2004,10,04));
        Book book7=new Book("Dönüşüm",160,"Franz Kafka",LocalDate.of(1940,04,05));
        Book book8=new Book("Siyah İnci",150,"Anna Sewell",LocalDate.of(2014,02,25));
        Book book9=new Book("Ejderhaların Dansı",700,"George R. R. Martin",LocalDate.of(2013,02,10));
        Book book10=new Book("Animal Farm",120,"George Orwell ",LocalDate.of(1945,8,17));

        ArrayList<Book> books=new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        System.out.println("All Book List");
        books.stream().forEach(book -> System.out.println(book.getName() + "\t" + book.getPage() + "\t"
                + book.getAuthorName() + "\t" + book.getReleaseDate()));
        System.out.println("");

        Map<String, String> mapBook = new HashMap<>();
        books.stream().forEach(book -> mapBook.put(book.getName(), book.getAuthorName()));

        System.out.println("Book name - Author name");
        for (String b:mapBook.keySet()){
            System.out.println("Book : " + b +", Author : " + mapBook.get(b));
        }
        System.out.println("");

        List<Book> filtredBook;
        filtredBook = books.stream().filter(book -> book.getPage() > 100).collect(Collectors.toList());

        System.out.println("Page > 100");
        filtredBook.stream().forEach(book -> System.out.println(book.getName() + "\t" + book.getPage() + "\t"
                + book.getAuthorName() + "\t" + book.getReleaseDate()));
        System.out.println("");
    }
}
