package org.skypro.skyshop.searchable;


import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
        this.count = 0;
    }

    public Searchable[] search(String term) {
        if (term == null || term.trim().isEmpty()) {
            return new Searchable[0];
        }
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (Searchable item : searchables) {
            if (item == null) continue;
            if (item.searchableName().toLowerCase().contains(term.toLowerCase())) {
                results[resultCount++] = item;
            }
            if (resultCount == 5) {
                break;

            }
        }
        if (resultCount < 5) {
            return Arrays.copyOf(results, resultCount);
        }
        return results;
    }

    public void printResults(Searchable[] results, String term) {

        if (results.length > 0) {
            System.out.println("Поиск результата для  " + term + ":");
            for (Searchable result : results) {
                System.out.println(result.getStringRepreseentation());
            }
        } else {
            System.out.println("Результаты для поиска < " + term + " > не найдены");
        }
    }

    public void add(Searchable item) {
        if (count < searchables.length) {
        }
        searchables[count++] = item;

    }
}
