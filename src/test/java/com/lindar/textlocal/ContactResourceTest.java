package com.lindar.textlocal;

import com.lindar.textlocal.vo.TextlocalGroupCreateResponse;
import com.lindar.textlocal.vo.TextlocalGroupListResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactResourceTest {


    private final String API_KEY = System.getenv("TEXTLOCAL_APIKEY");
    private final ContactResource contactResource = new ContactResource(API_KEY);

    @org.junit.jupiter.api.Test
    void createGroup() {
        TextlocalGroupCreateResponse response = contactResource.createGroup("Test Group");

        assertEquals("success", response.getStatus());
        assertEquals(true, response.getErrors().isEmpty(), "There should not be any errors");
        assertEquals(true, response.getWarnings().isEmpty(), "There should not be any warnings");
    }

    @org.junit.jupiter.api.Test
    void listGroups() {
        TextlocalGroupListResponse groupListResponse = contactResource.listGroups();

        assertEquals("success", groupListResponse.getStatus());
        assertEquals(true, groupListResponse.getErrors().isEmpty(), "There should not be any errors");
        assertEquals(true, groupListResponse.getWarnings().isEmpty(), "There should not be any warnings");
    }

    @org.junit.jupiter.api.Test
    void createBulkContacts() {
    }

    @org.junit.jupiter.api.Test
    void deleteContact() {
    }
}