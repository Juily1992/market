package org.skypro.skyshop.searchable;

import java.util.Comparator;

public class ReverseSearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthCompare = Integer.compare(s2.searchableName().length(), s1.searchableName().length());
                if (lengthCompare == 0) { return s2.getName().compareTo(s1.getName());}
        return lengthCompare;
    }
}
