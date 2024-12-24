package org.skypro.skyshop.bucket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.ProductNotFoundException;

import java.util.Scanner;

public class ProductBacket {

    private int size;
    private Product[] products;


    public Product[] getProducts() {
        return products;
    }

    public ProductBacket() {
        this.products = new Product[5];
    }

    public void addProductBusket(Product product) throws ProductNotFoundException {

        if (size >= products.length) {
            System.out.println("Нельзя добавить товар, корзина переполнена");
        }
        Product newProduct = new Product(product.getNameProduct(), product.getPrice());
        products[size++] = newProduct;


    }

    public int totalValue() {
        int totalValue = 0;
        for (int i = 0; i < size; i++) {
            if (products != null) {
                Product product = products[i];
                totalValue += product.getPrice();
            }
        }
        return totalValue;
    }

    public void printProduct() throws ProductNotFoundException {
        for (Product product : products) {
            if (product != null) {
                System.out.println("< " + product.getNameProduct() + " > : < " + product.getPrice() + " >");
            } else if (product == null) {
                products = null;
                System.out.println(products);
            }
        }
        System.out.println("Итого: " + totalValue());
    }

    public boolean productExistance(String clientName) throws ProductNotFoundException {
        boolean existance = false;
        if (products == null) {
            throw new ProductNotFoundException("Невозможно найти продукт в корзине, так как корзина пустая!");
        }
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (clientName.equals(product.getNameProduct())) {
                existance = true;
                System.out.println(existance);
            }
        }
        System.out.println(existance);
        return existance;
    }

    public void deleteProducts() {
        for (int i = 0; i < size; i++) {
            if (products != null) {
                products[i] = null;
            }
        }
    }


}

