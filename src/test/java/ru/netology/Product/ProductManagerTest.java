package ru.netology.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test

    public void AddThreeProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(product1);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1, product1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(product1);

        Product[] actual = manager.searchBy("Tales");
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchTwoProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Tales", 100);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(product1);

        Product[] actual = manager.searchBy("Tales");
        Product[] expected = {book1, product1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void searchNoProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(product1);

        Product[] actual = manager.searchBy("Random");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }


}
