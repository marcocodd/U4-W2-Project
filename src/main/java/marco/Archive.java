package marco;

import com.github.javafaker.Faker;
import com.mifmif.common.regex.Main;
import marco.entities.Book;
import marco.entities.CatalogElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;


public class Archive {
    private static Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {

        // Supplier per generare libri casuali, lo uso solo per generare una lista per poi lavorarci

        Supplier<Book> bookSupplier = () -> {
            Faker faker = new Faker();
            Random random = new Random();

            return new Book(faker.book().hashCode(),
                    faker.book().title(),
                    random.nextInt(1900, 2024), random.nextInt(10, 250), faker.book().author(), faker.book().genre());
        };

        List<CatalogElement> catalog = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            catalog.add(bookSupplier.get());
        }

        catalog.forEach(System.out::println);
        

    }
}
