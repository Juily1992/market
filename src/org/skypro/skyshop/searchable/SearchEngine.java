package org.skypro.skyshop.searchable;


import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;

public class SearchEngine {
    private Map<String, Searchable> searchables;
    private int count = 0;

    public SearchEngine() {
        this.searchables = new HashMap<>();
        this.count = 0;
    }

    public Map<String, Searchable> search(String term) {
        Map<String, Searchable> results = new TreeMap<>();
        for (Map.Entry<String, Searchable> item : this.searchables.entrySet()) {

            if (item == null) continue;
            if (item.getValue().searchableName().toLowerCase().contains(term.toLowerCase())) {
                results.put(item.getKey(), item.getValue());
            }
        }
        return results;
    }

    public void printResults(Map<String, Searchable> results, String term) throws NullPointerException {
        if (results.size() > 0) {
            System.out.println("Поиск результата для  " + term + ":");
            for (Map.Entry<String, Searchable> result : results.entrySet()) {
                System.out.println(result.getValue().getStringRepreseentation());
            }
        } else {
            System.out.println("Результаты для поиска < " + term + " > не найдены");
        }
    }

    public void add(Searchable item) {
        searchables.put(item.getStringRepreseentation(), item);
    }

    public Searchable bestSearchableResult(String term) throws BestResultNotFound {
        int max = 0;
        Searchable best = null;
        if (term == null || term.isBlank()) {
            throw new BestResultNotFound("Запрос не может быть пустым!");
        }
        for (Map.Entry<String, Searchable> item : searchables.entrySet()) {
            if (item == null) {
                continue;
            }
            String searchTerm = item.getValue().searchableName().toLowerCase();
            int count = (countBestSearchable(searchTerm, term));
            if (count > max) {
                max = count;
                best = item.getValue();
            }
        }
        if (best == null) {
            throw new BestResultNotFound("По запросу " + term + " ничего не найдено");
        }
        return best;
    }

    public int countBestSearchable(String searchTerm, String term) {
        if (searchTerm == null || term == null || term.isEmpty()) {
            throw new RuntimeException();
        }
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
