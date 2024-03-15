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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Magazine magazine = (Magazine) o;
        return periodicity == magazine.periodicity;
    }


}
