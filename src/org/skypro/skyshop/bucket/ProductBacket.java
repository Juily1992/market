package org.skypro.skyshop.bucket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.fixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.searchable.Searchable;

import java.util.*;

public class ProductBacket {

    private Map<String, ArrayList<Product>> products;

    public ProductBacket() {
        this.products = new TreeMap<>();
    }

    public Searchable addProductBusket(Product product) {
        String productName = product.getName();
        if (!products.containsKey(productName)) {
            products.put(productName, new ArrayList<>());
            ArrayList<Product> productList = products.get(productName);
        }
        products.get(productName).add(product);
        return product;
    }

    public int totalValue() throws ProductNotFoundException {
        int totalValue = 0;
        if (products.equals(null)) {
            throw new ProductNotFoundException("Итого: 0");
        }
        for (ArrayList<Product> productList : products.values()) {
            if (productList != null) {
                for (Product product : productList) {
                    if (product != null) {
                        totalValue += product.getPrice();
                    }
                }
            }
        }
        return totalValue;
    }

    public void printProduct() throws ProductNotFoundException {
        for (Map.Entry<String, ArrayList<Product>> product : products.entrySet()) {
            System.out.println(product.getValue().toString());
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
        if (products == null || products.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }
        ArrayList<String> iterator = new ArrayList<>(products.keySet());
        for (String product : iterator) {
            ArrayList<Product> productList = products.get(product);
            if (productList != null) {
                Iterator<Product> productIterator = productList.iterator();
                while (productIterator.hasNext()) {
                    Product productNext = productIterator.next();
                    if (productNext != null && productNext.getName().equals(name)) {
                        System.out.println(productNext.toString());
                        productIterator.remove();
                    }
                    if (productList.isEmpty()) {
                        products.remove(product);
                    }
                }
            }
        }
    }

    public int countIsSpecial() {
        int counter = 0;
        for (ArrayList<Product> product : products.values()) {
            if (product != null) ;
            {
                for (Product productSpecial : product) {
                    if (productSpecial != null && productSpecial.isSpecial()) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

}

