package org.skypro.skyshop;

import java.util.Objects;
import java.io.File;

import org.skypro.skyshop.ProductBusket;

public class App {
    public static void main(String[] args) throws ProductBusket.ProductNotFoundException {
        ProductBusket productBusket = new ProductBusket();

        productBusket.addProductBusket("Мыло", 30);
        productBusket.addProductBusket("Ёлка", 50);
        productBusket.addProductBusket("Гирлянда", 25);
        productBusket.addProductBusket("Книга", 13);
        productBusket.addProductBusket("Апельсины", 45);


        System.out.println("Содержимое корзины: ");
        productBusket.printProduct();
        System.out.println(productBusket.totalValue());

        System.out.println(productBusket.productExistance());
        productBusket.deleteProducts();
        productBusket.printProduct();
        try {
            productBusket.totalValue();
        } catch (ProductBusket.ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            productBusket.productExistance();
        } catch (ProductBusket.ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}
