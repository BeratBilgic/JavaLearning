package BookStreamExample;

import java.time.LocalDate;

public class Book {
    private String name,authorName;
    private int page;
    private LocalDate releaseDate;

    public Book(String name, int page, String authorName, LocalDate releaseDate) {
        this.name = name;
        this.authorName = authorName;
        this.page = page;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
