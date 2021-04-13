package ru.netology.manager;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;


public class ProductManagerTest { @Test
void shouldSearchNameBook() {
    ProductRepository repository=new ProductRepository();
    ProductManager manager=new ProductManager(repository);
    Book book1=new Book(1,"Мертвые Души",560,"Gogol");
    Book book2=new Book(2,"Война и мир",780,"Tolstoi");
    Book book3=new Book(3,"Собрание сочинений",890,"Pushkin");
    Book book4=new Book(4,"Honor",354,"NoAuthor");
    manager.add(book1);
    manager.add(book2);
    manager.add(book3);
    manager.add(book4);
    Product[] actual=manager.searchBy("Собрание сочинений");
    Product[] expected = new Product[]{book3};
    assertArrayEquals(expected, actual);
}

    @Test
    void shouldSearchAuthorBook() {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Book book1=new Book(1,"Мертвые Души",560,"Gogol");
        Book book2=new Book(2,"Война и мир",780,"Tolstoi");
        Book book3=new Book(3,"Собрание сочинений",890,"Pushkin");
        Book book4=new Book(4,"Honor",354,"NoAuthor");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual=manager.searchBy("Tolstoi");
        Product[] expected = new Product[]{book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoBook() {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Book book1=new Book(1,"Мертвые Души",560,"Gogol");
        Book book2=new Book(2,"Война и мир",780,"Tolstoi");
        Book book3=new Book(3,"Мертвые Души",560,"Gogol");
        Book book4=new Book(4,"Honor",354,"NoAuthor");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        Product[] actual=manager.searchBy("Мертвые Души");
        Product[] expected = new Product[]{book1, book3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameSmartphone () {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Smartphone smartphone1=new Smartphone(1,"Samsung A1", 9000, "Korea");
        Smartphone smartphone2=new Smartphone(2,"iPhone 12X", 100000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("iPhone 12X");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchManufacturerSmartphone () {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Smartphone smartphone1=new Smartphone(1,"Samsung A1", 9000, "Korea");
        Smartphone smartphone2=new Smartphone(2,"iPhone 12X", 100000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("USA");
        Product[] expected = new Product[]{smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchNameTwoSmartphone () {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Smartphone smartphone1=new Smartphone(1,"Samsung A1", 9000, "Korea");
        Smartphone smartphone2=new Smartphone(2,"Samsung A1", 9000, "Korea");
        Smartphone smartphone3=new Smartphone(3,"iPhone 12X", 100000, "USA");
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        Product[] actual=manager.searchBy("Samsung A1");
        Product[] expected = new Product[]{smartphone1, smartphone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookAndSmartphone() {
        ProductRepository repository=new ProductRepository();
        ProductManager manager=new ProductManager(repository);
        Book book1=new Book(1,"Мертвые Души",560,"Gogol");
        Book book2=new Book(2,"Война и мир",780,"Tolstoi");
        Book book3=new Book(3,"Мертвые Души",560,"Gogol");
        Book book4=new Book(4,"Samsung A1",354,"NoAuthor");
        Smartphone smartphone1=new Smartphone(1,"Samsung A1", 9000, "Korea");
        Smartphone smartphone2=new Smartphone(2,"iPhone 12X", 100000, "USA");
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual=manager.searchBy("Samsung A1");
        Product[] expected = new Product[]{book4, smartphone1};
        assertArrayEquals(expected, actual);
    }
}

