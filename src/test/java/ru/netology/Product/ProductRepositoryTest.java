package ru.netology.Product;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    @Test

    public void AddThreeProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        repo.save(book1);
        repo.save(smartphone1);
        repo.save(product1);


        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1, product1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void AddOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        repo.save(product1);

        Product[] actual = repo.findAll();
        Product[] expected = {product1};

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test

    public void deleteAllProducts() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        repo.save(book1);
        repo.save(smartphone1);
        repo.save(product1);
        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);

        Product[] actual = repo.findAll();
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void deleteOneProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        repo.save(book1);
        repo.save(smartphone1);
        repo.save(product1);
        repo.removeById(1);

        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, product1};

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void notFoundExceptionTest() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(01, "Tales", 500, "Grimm");
        Smartphone smartphone1 = new Smartphone(02, "Honor10", 30_000, "Honor");
        Product product1 = new Product(03, "Ручка", 100);

        repo.save(book1);
        repo.save(smartphone1);
        repo.save(product1);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(10));


    }

}

