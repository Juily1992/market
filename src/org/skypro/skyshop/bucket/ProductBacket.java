package org.skypro.skyshop.bucket;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.fixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.searchable.Searchable;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class ProductBacket {

    private Map<String, ArrayList<Product>> products;

    public ProductBacket() {
        this.products = new TreeMap<>();
    }

    public Searchable addProductBusket(Product product) {
        String productName = product.getName();
        products.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
        return product;
    }

    public int totalValue() throws ProductNotFoundException {
        if (products.equals(null)) {
            throw new ProductNotFoundException("Итого: 0");
        }
        return products.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public void printProduct() throws ProductNotFoundException {
        products.values().stream()
                .forEach(product -> System.out.println(product.toString()));
        System.out.println("Итого: " + totalValue());
    }

    public boolean productExistance(String clientName) throws ProductNotFoundException {
        if (products == null || products.isEmpty()) {
            return false;
        }
        return products.keySet().stream()
                .anyMatch(productName -> productName.equals(clientName));
    }

    public void deleteProducts() {
        products.clear();
    }

    public void deleteChosenProducts(String name) {
        if (products == null || products.isEmpty()) {
            System.out.println("Список пуст!");
            return;
        }
        List<String> deletedProducts = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Product>> entry : products.entrySet()) {
            String productName = entry.getKey();
            List<Product> chosenProducts = entry.getValue();
            if (chosenProducts != null) {
                List<Product> chosenProductsCopy = chosenProducts.stream()
                        .filter(product -> product != null && product.getName().equals(name))
                        .collect(Collectors.toList());
                chosenProductsCopy.forEach(product -> {
                    System.out.println("Удаляем" + product);
                    chosenProducts.remove(product);
                });
            }
            if (chosenProducts != null && chosenProducts.isEmpty()) {
                deletedProducts.add(productName);
            }
        }
        deletedProducts.forEach(products::remove);
    }

    public int countIsSpecial() {
        return (int) products.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();

    }
}

