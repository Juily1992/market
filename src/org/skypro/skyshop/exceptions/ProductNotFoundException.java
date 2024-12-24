package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class ProductNotFoundException extends Exception {

    public ProductNotFoundException(String message) {
        super(message);
    }

    public NullPointerException nullPointerException() {
        return new NullPointerException();
    }

}

