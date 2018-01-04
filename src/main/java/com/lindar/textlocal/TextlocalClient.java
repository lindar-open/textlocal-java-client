package com.lindar.textlocal;

public class TextlocalClient {

    private final ContactResource contactResource;
    private final ReportingResource reportingResource;


    public TextlocalClient(String apiKey) {
        this.contactResource = new ContactResource(apiKey);
        this.reportingResource = new ReportingResource(apiKey);
    }

    public ContactResource contacts() {
        return contactResource;
    }

    public ReportingResource reporting() {
        return reportingResource;
    }
}
