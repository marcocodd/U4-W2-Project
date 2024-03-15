package marco;

import marco.entities.Book;
import marco.entities.CatalogElement;
import marco.entities.Magazine;
import marco.entities.Periodicity;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Archive {

    private static List<CatalogElement> catalogElements = new ArrayList<>();

    public static void addElement(CatalogElement element) {
        try {
            if (catalogElements.contains(element)) {
                throw new IllegalArgumentException("Elemento già presente " + "isbn " + element.getIsbn());

            } else {
                catalogElements.add(element);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Errore nell'aggiunta dell'elemento, " + e.getMessage());
        }


    }

    public static List<CatalogElement> removeElement(long isbn) {
        try {
            // controllo che l'elemento ci sia altrimenti lancia exception
            if (catalogElements.stream().noneMatch(element -> element.getIsbn() == isbn)) {
                throw new IllegalArgumentException("Nessun Elemento trovato");
            } else {
                CatalogElement removedElement = catalogElements.stream()
                        .filter(element -> element.getIsbn() == isbn)
                        .findFirst()
                        .orElse(null);
                System.out.println("Elemento rimosso: " + removedElement);
                return catalogElements = catalogElements.stream()
                        .filter(element -> element.getIsbn() != isbn)
                        .toList();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(("Errore nella rimozione: " + e.getMessage()));
        }

        return catalogElements;
    }

    public static String findElementIsbn(long isbn) {
        try {
            // controllo che l'oggetto ci sia
            if (catalogElements.stream().noneMatch(element -> element.getIsbn() == isbn)) {
                throw new IllegalArgumentException("Nessun elemento trovato");
            } else {
                String foundElement = catalogElements.stream()
                        .filter(element -> element.getIsbn() == isbn)
                        .collect(Collectors.toList())
                        .toString();

                return foundElement;
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Errore nella ricerca: " + e.getMessage());
        }

        return null;
    }

    public static List<CatalogElement> searchByYear(int year) {
        List<CatalogElement> elementsByYear;
        try {
            // controllo che l'anno sia valido, numeri un pò a caso...
            if (year <= 0 || year < 500) {
                throw new IllegalArgumentException("Anno inserito non valido");
            } else {
                elementsByYear = catalogElements.stream().filter(element -> element.getYear() == year).toList();
                return elementsByYear;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }
        return new ArrayList<>();
    }

    public static List<CatalogElement> searchByAuthor(String author) {
        return catalogElements.stream().filter(element -> element instanceof Book).map(element -> element).filter(element -> ((Book) element).getAuthor().equals(author)).toList();
    }

    public static void saveArchive() {
        File savedArchive = new File("src/catalogo.txt");
        try {
            String catalogToString = catalogElements.stream().map(element -> element.toString()).collect(Collectors.joining(System.lineSeparator()));

            FileUtils.writeStringToFile(savedArchive, catalogToString, StandardCharsets.UTF_8, false);
            System.out.println("File salvato");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void loadArchive() {
        try {

            String contentFile = FileUtils.readFileToString(FileUtils.getFile("src/catalogo.txt"), StandardCharsets.UTF_8);
            System.out.println("archivio caricato:");
            System.out.println(contentFile);
        } catch (IOException e) {
            System.err.println("Errore nel recuperare il file " + e.getMessage());
        }
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
        //prova di aggiungere un oggetto già presente con lo stesso isbn
        Magazine magazine4 = new Magazine(444444444, "ProvaMagazine", 2000, 150, Periodicity.SEMIANNUAL);
        addElement(magazine4);

        System.out.println("Catalogo:");
        catalogElements.forEach(element -> System.out.println(element));

        // prova salvataggio file
        System.out.println(" ");
        saveArchive();


        // prova caricamento file
        System.out.println(" ");
        loadArchive();

        // rimozione elemento
        System.out.println(" ");
        removeElement(555555555);
        //rimozione elemento non esistente prova errore
        removeElement(1);


        System.out.println(" ");
        System.out.println("Catalogo dopo rimozione");
        catalogElements.forEach(element -> System.out.println(element));
        System.out.println(" ");
        //ricerca elemento tramite isbn
        System.out.println(" ");
        System.out.println("Elemento trovato " + findElementIsbn(333333333));

        //ricerca tramite anno
        System.out.println(" ");
        System.out.println("Elementi per anni" + searchByYear(2000));
        System.out.println(searchByYear(1));

        //ricerca tramite autore
        System.out.println(" ");
        System.out.println("Ricerca per autore" + searchByAuthor("Rowling"));

        // -------------------------------


    }


}
