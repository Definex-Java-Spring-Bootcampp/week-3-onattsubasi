package com.dijitalmarketim.dijitalmarketimservice.exceptions;

public class DijitalmarketimException extends RuntimeException {

    private String message;

    public DijitalmarketimException(String message) {
        super(message);
        this.message = message;
    }
}
