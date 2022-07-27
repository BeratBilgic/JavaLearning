package com.berat.bookstore;

import com.berat.bookstore.model.Book;
import com.berat.bookstore.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public BookStoreApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Book book1 = Book.builder()
				.name("The Little Prince")
				.author("Antoine de Saint-Exupéry")
				.price(10.0)
				.stock(10).build();
		Book book2 = Book.builder()
				.name("Lord of the Rings")
				.author("J. R. R. Tolkien")
				.price(30.45)
				.stock(10).build();
		Book book3 = Book.builder()
				.name("Animal Farm")
				.author("George Orwell")
				.price(19.99)
				.stock(10).build();
		bookRepository.saveAll(Arrays.asList(book1, book2, book3));
	}
}
