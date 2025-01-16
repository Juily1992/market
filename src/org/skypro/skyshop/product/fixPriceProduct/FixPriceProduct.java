package org.skypro.skyshop.product.fixPriceProduct;

import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 10;

    public FixPriceProduct(String nameProduct)  {
        super(nameProduct);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "< " + getNameProduct() + " > : < Фиксированная цена: " + FIXED_PRICE + " >";
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

}
