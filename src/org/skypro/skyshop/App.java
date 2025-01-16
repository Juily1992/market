package org.skypro.skyshop;

import org.skypro.skyshop.bucket.ProductBacket;
import org.skypro.skyshop.exceptions.ArticleNotFoundException;
import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.exceptions.ProductNotFoundException;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.discountedProduct.DiscountedProduct;
import org.skypro.skyshop.product.fixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.product.simpleProduct.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchable.SearchEngine;

public class App {
    public static void main(String[] args) throws ProductNotFoundException, ArticleNotFoundException {

        ProductBacket backet = new ProductBacket();

        SearchEngine searchEngine = new SearchEngine(15);
        searchEngine.add(backet.addProductBusket(new SimpleProduct("Арбуз", 4)));
        searchEngine.add(backet.addProductBusket(new SimpleProduct("Гирлянда Гирлянда", 10)));
        searchEngine.add(backet.addProductBusket(new DiscountedProduct("Гирлянда, Гирлянда, Гирлянда", 500, 50)));
        searchEngine.add(backet.addProductBusket(new DiscountedProduct("Книга", 400, 6)));
        searchEngine.add(backet.addProductBusket(new FixPriceProduct("Апельсины")));
        searchEngine.add(backet.addProductBusket(new FixPriceProduct("Яблоки")));
        Article.BucketArticle bucketArticle = new Article.BucketArticle();
        searchEngine.add(bucketArticle.addArticles(new Article("федорино горе", "Сказка")));
        searchEngine.add(bucketArticle.addArticles(new Article("Места обитания китов", "Рассматриваются наиболее известные места обитания ... ")));

        System.out.println("Содержимое корзины: ");
        try {
            backet.printProduct();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        bucketArticle.printArticle();

        // ловим ошибку в 3 неправильных товарах
        try {
            System.out.println();
            Product product = new SimpleProduct("HFNUF", -5);
            Product product1 = new SimpleProduct(null, 50);
            Product product2 = new DiscountedProduct("Расческа", 500, 127);
            searchEngine.add(product);
            searchEngine.add(product1);
            searchEngine.add(product2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        // метода вывода строки с наибольшим количеством повторов
        try {
            System.out.println("\n Демонстрация метода вывода строки с наибольшим количеством повторов: \n 1 Сценарий: ");
            System.out.println(searchEngine.bestSearchableResult("гирлянда"));
            System.out.println("2 сценарий: ");
            System.out.println(searchEngine.bestSearchableResult("  "));
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println();
            String term1 = "Гирлянда";
            searchEngine.printResults(searchEngine.search(term1), term1);
            String term2 = "наиболее";
            searchEngine.printResults(searchEngine.search(term2), term2);
            String term3 = " ";
            searchEngine.printResults(searchEngine.search(term3), term3);
            System.out.println("Итого: " + backet.totalValue());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }


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
