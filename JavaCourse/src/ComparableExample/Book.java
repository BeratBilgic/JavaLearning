package ComparableExample;

public class Book implements Comparable<Book>{
    String name;
    int page;

    public Book(String name, int page){
        this.name = name;
        this.page = page;
    }

    @Override
    public int compareTo(Book o) {
        return getName().compareTo(o.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
