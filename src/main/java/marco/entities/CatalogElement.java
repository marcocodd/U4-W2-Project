package marco.entities;

public abstract class CatalogElement {

    protected long isbn;
    protected String title;
    protected int year;
    protected int totalPages;

    public CatalogElement(long isbn, String title, int year, int totalPages) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.totalPages = totalPages;
    }

    public long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
