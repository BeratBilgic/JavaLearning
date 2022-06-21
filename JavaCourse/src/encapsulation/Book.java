package encapsulation;

public class Book {
    private String name,author,publisher;
    private int numberOfPage; 

    Book(String name, int numberOfPage, String auther, String publisher){
        this.name = name;
        this.author = auther;
        this.publisher = publisher;
        if (numberOfPage > 0) {
            this.numberOfPage = numberOfPage;
        }
        else
        {
            this.numberOfPage = 0;
        }
    }

    public int getNumberOfPage(){
        return this.numberOfPage;
    }
    public void setNumberOfPage(int size){
        if (size > 0) {
            this.numberOfPage = size;
        }else
        {
            this.numberOfPage = 0;
            System.out.println("wrong number of page");
        }
    }
    public String getName(){
        return this.name;
    }
    public String setName(String name){
        return this.name = name;
    }

    public String getAuthor(){
        return this.author;
    }
    public String setAuthor(String author){
        return this.author = author;
    }

    public String getPublisher(){
        return this.publisher;
    }
    public String setPublisher(String publisher){
        return this.publisher = publisher;
    }
}
