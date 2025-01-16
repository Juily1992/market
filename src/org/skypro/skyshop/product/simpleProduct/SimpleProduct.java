package org.skypro.skyshop.product.simpleProduct;

import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.Product;

public class SimpleProduct extends Product {
    final int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        try {
            if (price <= 0) {
                throw new IllegalArgumentException("Цена не может быть меньше 0 или = 0");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
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
