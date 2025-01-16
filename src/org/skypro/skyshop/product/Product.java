package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;


public abstract class Product implements Searchable {
    final String nameProduct;

    public Product(String nameProduct) throws IllegalArgumentException {
        try {
            if (nameProduct == null || nameProduct.isBlank() || nameProduct.equalsIgnoreCase("null")) {
                throw new IllegalArgumentException("Продукт не может быть null или пуст!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getName() {

        return nameProduct;
    }

    @Override
    public String searchableName() {
        return nameProduct;
    }

    @Override
    public String typeContent() {
        return "PRODUCT";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct);
    }

}
