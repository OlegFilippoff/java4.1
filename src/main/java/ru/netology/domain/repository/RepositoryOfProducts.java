package ru.netology.domain.repository;

import ru.netology.domain.Product;
import ru.netology.domain.exeptions.NotFoundException;

import java.util.Objects;

public class RepositoryOfProducts {
    private Product[] items = new Product[0];


    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
//        Product[] tmp = new Product[items.length];
//        for (int i = 0; i < items.length; i++) {
//            System.arraycopy(items,0,tmp,0,items.length);
//        }
//        return tmp;
    }

    public Product findById(int id) {

        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) throws RuntimeException {

        //    try {
        if (findById(id) == null) throw new NotFoundException("ID " + id + " does not exist");

        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;

//        } catch (NotFoundException ex) {
//            System.out.println(ex.getMessage());
//            ex.printStackTrace();
//            throw new NotFoundException(ex.getMessage());
//        }finally {
//           System.out.println("Input new id");
//        }
    }
}






