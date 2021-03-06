package ru.netology.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exeptions.NotFoundException;
import ru.netology.manager.Manager;
import ru.netology.repository.RepositoryOfProducts;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryOfProductsTest {

    RepositoryOfProducts repository = new RepositoryOfProducts();
    Manager manager = new Manager(repository);
    Product phone1 = new Smartphone(05, "A52", 150000, "Samsung");
    Product phone2 = new Smartphone(42, "p50", 250000, "Huawei");
    Product book1 = new Book(001, "Над пропастью во ржи", 150, "Селинджер");
    Product book2 = new Book(003, "Война миров", 200, "Уэллс");


    @Test
    void removeByNonExistingIdInRepo() {
        repository.save(phone1);
        repository.save(phone2);

        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(8));

    }

    @Test
    void removeByExistingIdInRepo() {
        repository.save(phone1);
        repository.save(phone2);
        repository.removeById(05);
        Product[] expected = {phone2};

        assertArrayEquals(expected, repository.findAll());
    }
}




