package org.skypro.skyshop.article;

import org.skypro.skyshop.exceptions.ArticleNotFoundException;
import org.skypro.skyshop.searchable.Searchable;

public class Article implements Searchable {
    private String title;
    private String description;

    public Article(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "Название статьи: " + title + "\n" + "Текст статьи: " + description;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public String searchableName() {
        return title + " - " + description;
    }

    @Override
    public String typeContent() {
        return "ARTICLE";
    }

    public static class BucketArticle {
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
}
