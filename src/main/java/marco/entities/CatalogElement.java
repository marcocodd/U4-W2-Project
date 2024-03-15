package marco.entities;

import java.util.Objects;

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


    @Override
    public String toString() {
        return "CatalogElement{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", totalPages=" + totalPages +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CatalogElement that = (CatalogElement) o;
        return isbn == that.isbn && year == that.year && totalPages == that.totalPages && Objects.equals(title, that.title);
    }


}
