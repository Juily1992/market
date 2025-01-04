package org.skypro.skyshop.searchable;

public interface Searchable {
    String searchableName();

    String getName();

    String typeContent();

    default String getStringRepreseentation() {
        return getName() + " - " + typeContent();
    }

}
