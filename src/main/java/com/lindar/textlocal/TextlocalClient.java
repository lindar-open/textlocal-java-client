package com.lindar.textlocal;

public class TextlocalClient {

    private final ContactResource contactResource;

    public TextlocalClient(String apiKey) {
        this.contactResource = new ContactResource(apiKey);
    }

    public ContactResource contacts() {
        return contactResource;
    }
}
