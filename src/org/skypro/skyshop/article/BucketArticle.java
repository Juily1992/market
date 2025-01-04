package org.skypro.skyshop.article;

import org.skypro.skyshop.exceptions.ArticleNotFoundException;
import org.skypro.skyshop.searchable.Searchable;
import java.util.Arrays;

public class BucketArticle {
    private Article[] articles;
    private int size;

    public BucketArticle() {
        this.articles = new Article[5];
    }

    public Searchable addArticles(Article article) {
        if (size >= articles.length) {
            System.out.println("Нельзя добавить товар, корзина переполнена");
        }
        this.articles[size++] = article;
        return article;
    }

    public void printArticle() throws ArticleNotFoundException {
        for (int i = 0; i < size; i++) {
            Article article = articles[i];
            if (article != null) {
                System.out.println(article.toString());
            } else if (article == null) {
                System.out.println(article);
            }
        }
    }

}
