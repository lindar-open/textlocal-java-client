package com.lindar.textlocal;

import com.lindar.textlocal.vo.*;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportsResourceTest {

    private final String API_KEY = System.getenv("TEXTLOCAL_APIKEY");
    private final ReportingResource reportingResource = new ReportingResource(API_KEY);

    @org.junit.jupiter.api.Test
    void fetchReports() {

        TextlocalMessageHistoryRequest request = TextlocalMessageHistoryRequest.builder()
                //.startDate(ZonedDateTime.now().minusDays(20))
                //.limit(100)
                .build();

        TextlocalGroupMessageHistoryResponse response = reportingResource.groupMessageHistory(request);
        assertEquals("success", response.getStatus());
        assertEquals(true, response.getErrors().isEmpty(), "There should not be any errors");
        assertEquals(true, response.getWarnings().isEmpty(), "There should not be any warnings");
    }

    @org.junit.jupiter.api.Test
    void fetchBatchStatus() {

        TextlocalBatchStatusResponse response = reportingResource.batchStatus(514142621);
        assertEquals("success", response.getStatus());
        assertEquals(true, response.getErrors().isEmpty(), "There should not be any errors");
        assertEquals(true, response.getWarnings().isEmpty(), "There should not be any warnings");
    }

}