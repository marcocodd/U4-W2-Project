package marco.entities;

public class Book extends CatalogElement {

    private String author;
    private String genre;


    public Book(long isbn, String title, int year, int totalPages, String author, String genre) {
        super(isbn, title, year, totalPages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", totalPages=" + totalPages +
                '}';
    }
}
