package marco;

import marco.entities.Book;
import marco.entities.CatalogElement;
import marco.entities.Magazine;
import marco.entities.Periodicity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Archive {

    private static List<CatalogElement> catalogElements = new ArrayList<>();

    public static void addElement(CatalogElement element) {
        catalogElements.add(element);

    }

    public static List<CatalogElement> removeElement(long isbn) {
        return catalogElements = catalogElements.stream().filter(element -> element.getIsbn() != isbn).toList();

    }

    public static String findElementIsbn(long isbn) {
        String foundElement;
        foundElement = catalogElements.stream().filter(element -> element.getIsbn() == isbn).collect(Collectors.toList()).toString();
        return foundElement;
    }

    public static List<CatalogElement> searchByYear(int year) {

        return catalogElements.stream().filter(element -> element.getYear() == year).toList();

    }

    public static List<CatalogElement> searchByAuthor(String author) {
        return catalogElements.stream().filter(element -> element instanceof Book).map(element -> element).filter(element -> ((Book) element).getAuthor().equals(author)).toList();
    }

    public static void main(String[] args) {

        // elementi per prova

        Book book1 = new Book(123456789, "Harry Potter", 2000, 1500, "Rowling", "Fantasy");
        addElement(book1);
        Book book2 = new Book(987654321, "Ciao", 1950, 150, "Aldo", "Comedy");
        addElement(book2);
        Magazine magazine1 = new Magazine(555555555, "Vogue", 2000, 50, Periodicity.WEEKLY);
        addElement(magazine1);
        Magazine magazine2 = new Magazine(333333333, "Geographic", 2005, 30, Periodicity.MONTHLY);
        addElement(magazine2);
        Magazine magazine3 = new Magazine(444444444, "ProvaMagazine", 2000, 150, Periodicity.SEMIANNUAL);
        addElement(magazine3);

        catalogElements.forEach(element -> System.out.println(element));

        removeElement(555555555);

        catalogElements.forEach(element -> System.out.println(element));

        System.out.println("Elemento trovato " + findElementIsbn(333333333));

        System.out.println("Elementi per anni" + searchByYear(2000));

        System.out.println("Ricerca per autore" + searchByAuthor("Rowling"));
        // -------------------------------
    }


}
