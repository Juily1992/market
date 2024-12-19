package org.skypro.skyshop;
import org.skypro.skyshop.bucket.ProductBacket;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) throws ProductNotFoundException {

        ProductBacket backet = new ProductBacket();
        backet.addProductBusket(new Product("Груша", 4));
        backet.addProductBusket(new Product("Ёлка",50));
        backet.addProductBusket(new Product("Гирлянда",25));
        backet.addProductBusket(new Product("Книга",13));
        backet.addProductBusket(new Product("Апельсины",45));

        System.out.println("Содержимое корзины: ");

        backet.printProduct();
        System.out.println(backet.totalValue());

        backet.productExistance();
        backet.deleteProducts();
         backet.printProduct();

        try {
            backet.totalValue();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            backet.productExistance();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}