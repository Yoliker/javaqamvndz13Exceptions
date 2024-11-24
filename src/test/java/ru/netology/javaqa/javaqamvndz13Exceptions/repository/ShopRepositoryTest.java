package ru.netology.javaqa.javaqamvndz13Exceptions.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    Product product1 = new Product(55, "ручка", 250);
    Product product2 = new Product(22, "карандаш", 100);
    Product product3 = new Product(12, "пенал", 520);

    @Test
    public void shouldNotFindExceptionInRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

    /*  repo.removeById(5);

        Product[] expected = { product1, product2, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);  */

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

    @Test
    public void shouldCheckRemoveById() {
        ShopRepository repo = new ShopRepository();
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.removeById(product1.getId());

        Product[] expected = {product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetProductPrice() {

        Assertions.assertEquals(250, product1.getPrice());
        Assertions.assertEquals(100, product2.getPrice());
        Assertions.assertEquals(520, product3.getPrice());
    }

    @Test
    public void shouldGetProductTitle() {
        Assertions.assertEquals("ручка", product1.getTitle());
        Assertions.assertEquals("карандаш", product2.getTitle());
        Assertions.assertEquals("пенал", product3.getTitle());
    }

    @Test
    public void shouldSetProductPrice() {
        product1.setPrice(300);
        product2.setPrice(130);
        product3.setPrice(580);

        Assertions.assertEquals(300, product1.getPrice());
        Assertions.assertEquals(130, product2.getPrice());
        Assertions.assertEquals(580, product3.getPrice());
    }

    @Test
    public void shouldSetProductTitle() {
        product1.setTitle("степлер");
        product2.setTitle("ластик");
        product3.setTitle("набор фломастеров");


        Assertions.assertEquals("степлер", product1.getTitle());
        Assertions.assertEquals("ластик", product2.getTitle());
        Assertions.assertEquals("набор фломастеров", product3.getTitle());
    }

}
