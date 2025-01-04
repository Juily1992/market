package org.skypro.skyshop;

import org.skypro.skyshop.article.BucketArticle;
import org.skypro.skyshop.bucket.ProductBacket;
import org.skypro.skyshop.exceptions.ArticleNotFoundException;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.discountedProduct.DiscountedProduct;
import org.skypro.skyshop.product.fixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.product.simpleProduct.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchable.SearchEngine;
import org.skypro.skyshop.searchable.Searchable;

public class App {
    public static void main(String[] args) throws ProductNotFoundException, ArticleNotFoundException {

        ProductBacket backet = new ProductBacket();

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.add(backet.addProductBusket(new SimpleProduct("Груша", 4)));
        searchEngine.add(backet.addProductBusket(new SimpleProduct("Ёлка", 50)));
        searchEngine.add(backet.addProductBusket(new DiscountedProduct("Гирлянда", 500, 50)));
        searchEngine.add(backet.addProductBusket(new DiscountedProduct("Книга", 400, 75)));
        searchEngine.add(backet.addProductBusket(new FixPriceProduct("Апельсины")));
        searchEngine.add(backet.addProductBusket(new FixPriceProduct("Яблоки")));
        BucketArticle bucketArticle = new BucketArticle();
        searchEngine.add(bucketArticle.addArticles(new Article("федорино горе", "Сказка")));
        searchEngine.add(bucketArticle.addArticles(new Article("Места обитания китов", "Рассматриваются наиболее известные места обитания ... ")));


        System.out.println("Содержимое корзины: ");
        backet.printProduct();
        bucketArticle.printArticle();

        String term1 = "4";
        searchEngine.printResults(searchEngine.search(term1), term1);

        String term2 = "наиболее";
        searchEngine.printResults(searchEngine.search(term2), term2);

        String term3 = " ";
        searchEngine.printResults(searchEngine.search(term3), term3);

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
