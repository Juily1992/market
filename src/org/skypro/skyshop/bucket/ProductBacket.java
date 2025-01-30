package org.skypro.skyshop.bucket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.fixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.searchable.Searchable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ProductBacket {

    private Map<String, Product> products;

    public ProductBacket() {
        this.products = new TreeMap<>();
    }

    public Searchable addProductBusket(Product product) {
        products.put(product.getName(), product);
        return product;
    }

    public int totalValue() throws ProductNotFoundException {
        int totalValue = 0;
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            totalValue += product.getPrice();
        }
        return totalValue;
    }

    public void printProduct() throws ProductNotFoundException {
        for (Map.Entry m : products.entrySet()) {
            System.out.println(m.getValue());
        }
        System.out.println("Итого: " + totalValue());
    }

    public boolean productExistance(String clientName) throws ProductNotFoundException {
        boolean existance = false;
        for (Map.Entry m : products.entrySet()) {
            if (clientName.equalsIgnoreCase(products.entrySet().iterator().next().getKey())) {
                existance = true;
            }
        }
        return existance;
    }

    public void deleteProducts() {
        products.clear();
    }

    public void deleteChosenProducts(String name) {
        Iterator<Map.Entry<String, Product>> iterator = products.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Product> entry = products.entrySet().stream().iterator().next();
            Product product = entry.getValue();
            if (product.getName().equals(name)) {
                System.out.println(product.toString());
                iterator.remove();
            }
        }
    }

    public int countIsSpecial() {
        int counter = 0;
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            Product product = entry.getValue();
            if (products != null && product.isSpecial()) {
                counter++;
            }
        }
        return counter;
    }

}

