package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Shirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Shirt shirt1 = new Shirt(33, "Polo", 20999, "red", "XL");
    private Book book1 = new Book(8, "Great book", 1000, "Donald Duck", 302, 1999);
    private Product product1 = new Product(19, "Weird stuff", 899);


    @BeforeEach
    public void setUp() {
        repository.save(book1);
        repository.save(product1);
        repository.save(shirt1);
    }

    @Test
    public void shouldRemoveById() {
        repository.removeById(8);

        Product[] expected = new Product[]{product1, shirt1};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdException() {
        assertThrows(NotFoundException.class, () -> repository.removeById(1));
    }
}

