package org.skypro.skyshop.product.simpleProduct;

import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    final int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        this.price = price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return "< " + getNameProduct() + " > : < " + price + " >";
    }

    @Override
    public int getPrice() {
        return price;
    }
}
