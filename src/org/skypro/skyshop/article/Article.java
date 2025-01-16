package org.skypro.skyshop.article;

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
}
