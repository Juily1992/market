package org.skypro.skyshop;

import org.skypro.skyshop.bucket.ProductBacket;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.discountedProduct.DiscountedProduct;
import org.skypro.skyshop.product.fixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.product.simpleProduct.SimpleProduct;

public class App {
    public static void main(String[] args) throws ProductNotFoundException {

        ProductBacket backet = new ProductBacket();
        backet.addProductBusket(new SimpleProduct("Груша", 4));
        backet.addProductBusket(new SimpleProduct("Ёлка", 50));
        backet.addProductBusket(new DiscountedProduct("Гирлянда", 500, 50));
        backet.addProductBusket(new DiscountedProduct("Книга", 400, 75));
        backet.addProductBusket(new FixPriceProduct("Апельсины"));
        backet.addProductBusket(new FixPriceProduct("Яблоки"));
        System.out.println("Содержимое корзины: ");
        backet.printProduct();
        System.out.println("Итого: " + backet.totalValue());
        System.out.println("Количество специальных товаров: " + backet.countIsSpecial());
        System.out.println("Проверка наличия товара в корзине: " + backet.productExistance("Книга"));
        backet.deleteProducts();
        System.out.println("Содержимое корзины после очистки: ");
        try {
            backet.printProduct();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Стоимость товаров в корзине после очистки: ");
        try {
            backet.totalValue();

        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Проверка наличия товара в корзине: ");
        try {
            System.out.println(backet.productExistance("Мыло"));
        } catch (NullPointerException e) {
            System.out.println("Невозможно найти продукт, так как корзина пустая");
        }


    }
}
