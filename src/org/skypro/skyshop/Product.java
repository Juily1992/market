package org.skypro.skyshop;
import java.util.Objects;


public class Product {
    private String nameProduct;
    private int price;

    public Product(String nameProduct, int price) {
            this.nameProduct = nameProduct;
            this.price = price;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
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
