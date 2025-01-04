package org.skypro.skyshop.bucket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.searchable.Searchable;

import java.util.Arrays;

public class ProductBacket {

    private int size;
    private Product[] products;
    static int counter = 0;

    public ProductBacket() {
        this.products = new Product[7];
    }

    public Searchable addProductBusket(Product product) {

        if (size >= products.length) {
            System.out.println("Нельзя добавить товар, корзина переполнена");
        }
        this.products[size++] = product;
        return product;
    }


    public int totalValue() throws ProductNotFoundException {
        int totalValue = 0;
        for (int i = 0; i < size; i++) {
            if (products[i] == null) {
                throw new ProductNotFoundException("Итого: 0");
            }
            if (products != null) {
                Product product = products[i];
                totalValue += product.getPrice();
            } else {
                totalValue = 0;
            }
        }

        return totalValue;
    }

    public void printProduct() throws ProductNotFoundException {
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.toString());
            } else if (product == null) {
                System.out.println(product);
            }
        }

        System.out.println("Итого: " + totalValue());
    }

    public boolean productExistance(String clientName) throws ProductNotFoundException {
        boolean existance = false;

        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (clientName.equals(product.getNameProduct())) {
                existance = true;
            }
        }
        return existance;
    }

    public void deleteProducts() {
        Arrays.fill(products, null);
    }

    public int countIsSpecial() {
        for (int i = 0; i < size; i++) {
            if (products[i] != null && products[i].isSpecial()) {
                counter++;
            }
        }
        return counter;
    }

}

