package org.skypro.skyshop;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ProductBusket {
    private int totalValue = 0;
    private int size;
    private Product[] products;
    private String clientName;
    private boolean existance;
    private String a;

    public ProductBusket() {
        this.products = new Product[5];
    }

    public void addProductBusket(String nameProduct, int price) {
        if (size >= products.length) {
            System.out.println("Нельзя добавить товар, корзина переполнена");
        }
        Product newProduct = new Product(nameProduct, price);
        products[size++] = newProduct;

    }

    class ProductNotFoundException extends Exception {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }

    public String totalValue() throws ProductNotFoundException {
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (products[i] == null) {
                throw new ProductNotFoundException("Сумма товаров в корзине = 0");
            } else if (products != null) {
                totalValue += product.getPrice();
            }
        }
        return "Стоимость вашей корзины: " + totalValue;

    }

    public void printProduct() {
        for (int i = 0; i < size; i++) {
            Product product = products[i];
            if (products[i] != null) {
                System.out.println("Наименование товара: " + product.getNameProduct() + ". Цена товара: " + product.getPrice());
            } else if (products[i] == null) {
                products[i] = null;
                System.out.println(products[i]);

            }

        }
    }

    public Boolean productExistance() throws ProductNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя продукта: ");
        clientName = scanner.nextLine();
        for (int i = 0; i < size; i++) {
            if (products[i] == null) {
                throw new ProductNotFoundException("Невозможно найти продукт в корзине, так как корзина пустая!");
            }
            Product product = products[i];
            if (clientName.equals(product.getNameProduct())) {
                existance = true;
            }
        }
        return existance;
    }

    public void deleteProducts() {
        for (int i = 0; i < size; i++) {
            if (products != null) {
                products[i] = null;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductBusket that = (ProductBusket) o;
        return totalValue == that.totalValue && size == that.size && existance == that.existance && Objects.deepEquals(products, that.products) && Objects.equals(clientName, that.clientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalValue, size, Arrays.hashCode(products), clientName, existance);
    }

    @Override
    public String toString() {
        return "ProductBusket{" +
                "totalValue=" + totalValue +
                '}';
    }
}

