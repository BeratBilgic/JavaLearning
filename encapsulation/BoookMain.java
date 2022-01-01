package encapsulation;

public class BoookMain {
    public static void main(String[] args) {
        Book b1 = new Book("Ali Father", 300,"Ali","Ali Publisher");
        Book b2 = new Book("Lord of The Rings", 500 , "Peter Jackson", "Tolkien Publisher");

        b1.setNumberOfPage(-200);
        System.out.println(b1.getNumberOfPage());
        b2.setAuthor("Tolkien");
        System.out.println(b2.getAuthor());
    }
}
