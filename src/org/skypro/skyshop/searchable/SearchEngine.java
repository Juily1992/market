package org.skypro.skyshop.searchable;


import org.skypro.skyshop.exceptions.BestResultNotFound;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {
    private final Set<Searchable> searchables;
    private int count = 0;

    public SearchEngine() {
        this.searchables = new HashSet<>();
        this.count = 0;
    }

    public Set<Searchable> search(String term) {
                Set<Searchable> results = searchables.stream()
                .filter(Objects::nonNull)
                .filter(searchable -> searchable.searchableName().toLowerCase().contains(term.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new ReverseSearchableComparator())));
        return results;
    }

    public void printResults(Set<Searchable> results, String term) throws NullPointerException {
        if (results.size() > 0) {
            System.out.println("Поиск результата для  " + term + ":");
            for (Searchable result : results) {
                System.out.println(result.getStringRepreseentation());
            }
        } else {
            System.out.println("Результаты для поиска < " + term + " > не найдены");
        }
    }

    public void add(Searchable item) {
        searchables.add(item);
    }

    public Searchable bestSearchableResult(String term) throws BestResultNotFound {
        int max = 0;
        Searchable best = null;
        if (term == null || term.isBlank()) {
            throw new BestResultNotFound("Запрос не может быть пустым!");
        }
        for (Searchable item : searchables) {
            if (item == null) {
                continue;
            }
            String searchTerm = item.searchableName().toLowerCase();
            int count = (countBestSearchable(searchTerm, term));
            if (count > max) {
                max = count;
                best = item;
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
