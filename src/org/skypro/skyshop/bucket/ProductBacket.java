package org.skypro.skyshop.bucket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.searchable.Searchable;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductBacket {

    private ArrayList<Product> products;

    public ProductBacket() {
        this.products = new ArrayList<>();
    }

    public Searchable addProductBusket(Product product) {
        products.add(product);
        return product;
    }


    public int totalValue() throws ProductNotFoundException {
        int totalValue = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.equals(null)) {
                throw new ProductNotFoundException("Итого: 0");
            }
            Product product = products.get(i);
            totalValue += product.getPrice();
        }

        return totalValue;
    }

    public void printProduct() throws ProductNotFoundException {
        for (Product product : products) {
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

        for (Product product : products) {
            if (clientName.equalsIgnoreCase(product.getName())) {
                existance = true;
            }
        }
        return existance;
    }

    public void deleteProducts() {
        products.clear();
    }

    public void deleteChosenProducts(String name) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(name)) {
                System.out.println(product.toString());
                iterator.remove();
            }
        }
    }

    public int countIsSpecial() {
        int counter = 0;
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (products.get(i) != null && product.isSpecial()) {
                counter++;
            }
        }
        return counter;
    }

}

