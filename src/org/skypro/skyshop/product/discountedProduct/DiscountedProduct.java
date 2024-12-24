package org.skypro.skyshop.product.discountedProduct;

import org.skypro.skyshop.product.Product;

public class DiscountedProduct extends Product {
    protected int basePrice;
    public int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return getBasePrice() - ((getDiscount() * getBasePrice()) / 100);
    }

    @Override
    public String toString() {
        return "< " + getNameProduct() + " > : < " + getPrice() + " > ( < " + getDiscount() + "% >)";
    }
}

