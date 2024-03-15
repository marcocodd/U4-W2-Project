package marco.entities;

public class Magazine extends CatalogElement {
    private Periodicity periodicity;

    public Magazine(long isbn, String title, int year, int totalPages, Periodicity periodicity) {
        super(isbn, title, year, totalPages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", totalPages=" + totalPages +
                '}';
    }
}
