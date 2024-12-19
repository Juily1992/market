package org.skypro.skyshop.product;

import java.util.Objects;
import org.skypro.skyshop.product.Product;

public class Product {
    final String nameProduct;
    final int price;

    public Product(String nameProduct, int price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

        public String getNameProduct() {
        return nameProduct;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(nameProduct, product.nameProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameProduct, price);
    }

    @Override
    public String toString() {
        return "Название продукта " + nameProduct + ", Цена = " + price;
    }
}
