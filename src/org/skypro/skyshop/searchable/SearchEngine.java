package org.skypro.skyshop.searchable;


import org.skypro.skyshop.exceptions.BestResultNotFound;

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

    public void printResults(Searchable[] results, String term) throws NullPointerException {

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

    public Searchable bestSearchableResult(String term) throws BestResultNotFound {
        int max = 0;
        Searchable best = null;
        for (Searchable item : searchables) {
            try {
                if (term == null || term.isBlank()) {
                    throw new BestResultNotFound("Запрос не может быть пустым!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println();
            }
            if (item == null) {
                continue;
            }
            try {
                String searchTerm = item.searchableName().toLowerCase();
                int count = (countBestSearchable(searchTerm, term));
                if (count > max) {
                    max = count;
                    best = item;
                }
            } catch (NullPointerException e) {
                System.out.println();
            }
        }
        if (best == null) {
            throw new BestResultNotFound("По запросу " + term + " ничего не найдено");
        }
        return best;
    }

    public int countBestSearchable(String searchTerm, String term) throws BestResultNotFound {

        int count = 0;
        int index = 0;
        int substrindex = searchTerm.indexOf(term, index);
        while (substrindex != -1) {
            count++;
            index = substrindex + term.length();
            substrindex = searchTerm.indexOf(term, index);
        }
        return count;

    }
}
