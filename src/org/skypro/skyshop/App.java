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
    public static void main(String[] args) {

        ProductBacket backet = new ProductBacket();

        SearchEngine searchEngine = new SearchEngine();
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
            bucketArticle.printArticle();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ArticleNotFoundException e) {
            throw new RuntimeException(e);
        }

        // ловим ошибку в 3 неправильных товарах
        try {
            System.out.println();
            Product product = new SimpleProduct("HFNUF", -5);
            Product product1 = new SimpleProduct("fdvb", 50);
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
            System.out.println(searchEngine.bestSearchableResult(null));
        } catch (BestResultNotFound e) {
            System.out.println("Запрос не может быть пустым!");
        }

        try {
            System.out.println("Демонстрация метода удаления товара из корзины по названию через итератор: ");
//            backet.deleteChosenProducts("Книга");  // демонстрация метода удаления товара из корзины по названию через итератор
            System.out.println();
            String term1 = "Гирлянда";
            searchEngine.printResults(searchEngine.search(term1), term1);
            String term2 = "наиболее";
            searchEngine.printResults(searchEngine.search(term2), term2);
            String term3 = " ";
            searchEngine.printResults(searchEngine.search(term3), term3);
            System.out.println("Итого: " + backet.totalValue());
            System.out.println("Количество специальных товаров: " + backet.countIsSpecial());
            System.out.println("Проверка наличия товара в корзине: " + backet.productExistance("Гирлянда гирлянда"));
            System.out.println("Содержимое корзины после очистки: ");
            backet.deleteProducts();
            backet.printProduct();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Стоимость товаров в корзине после очистки: ");
            backet.totalValue();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Проверка наличия товара в корзине: ");
        try {
            System.out.println(backet.productExistance("гирлянда"));
        } catch (ProductNotFoundException e) {
            System.out.println("Невозможно найти продукт, так как корзина пустая!");
        } catch (RuntimeException e) {
            System.out.println("Невозможно найти продукт, так как корзина пустая!");
        }

    }
}
