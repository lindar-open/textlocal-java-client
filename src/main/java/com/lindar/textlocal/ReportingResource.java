package com.lindar.textlocal;

import com.google.gson.*;
import com.lindar.textlocal.vo.*;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportingResource extends BaseResource {


    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String MIN_TIME_FIELD = "min_time";
    private static final String MAX_TIME_FIELD = "max_time";
    private static final String START_FIELD = "start";
    private static final String LIMIT_FIELD = "limit";
    private static final String SORT_ORDER_FIELD = "sort_order";

    private static final String BATCH_ID_FIELD = "batch_id";

    private static final int MAX_LIMIT = 1000;

    ReportingResource(String apiKey) {
        super(apiKey);
    }

    public TextlocalGroupMessageHistoryResponse groupMessageHistory(TextlocalMessageHistoryRequest request){

        if(request == null) throw new IllegalArgumentException("Request must not be blank");
        if(request.getLimit() < 0 || request.getLimit() > MAX_LIMIT) throw new IllegalArgumentException("Limit must be between 0 (default limit) and " + MAX_LIMIT);
        if(request.getStart() < 0) throw new IllegalArgumentException("Start must be >= 0");

        Map<String, String> params = new HashMap<>();

        if(request.getLimit() != 0){
            params.put(LIMIT_FIELD, String.valueOf(request.getLimit()));
        }

        if(request.getStart() != 0){
            params.put(START_FIELD, String.valueOf(request.getStart()));
        }

        if(request.getSortDirection() != null) {
            params.put(SORT_ORDER_FIELD, request.getSortDirection().name().toLowerCase());
        }

        if(request.getStartDate() != null){
            params.put(MIN_TIME_FIELD, String.valueOf(request.getStartDate().toEpochSecond()));
        }

        if(request.getEndDate() != null){
            params.put(MAX_TIME_FIELD, String.valueOf(request.getEndDate().toEpochSecond()));
        }

        return newPostRequest(Endpoints.Reporting.GROUP_MESSAGE_HISTORY, params)
                .fromJson()
                .gsonCustomiser(this::customiseGson)
                .castTo(TextlocalGroupMessageHistoryResponse.class);
    }

    public TextlocalBatchStatusResponse batchStatus(long batchId){

        if(batchId <= 0) throw new IllegalArgumentException("batch id must be valid");

        Map<String, String> params = new HashMap<>();

        params.put(BATCH_ID_FIELD, String.valueOf(batchId));

        return newPostRequest(Endpoints.Reporting.BATCH_STATUS, params)
                .fromJson()
                .castTo(TextlocalBatchStatusResponse.class);
    }

    private void customiseGson(GsonBuilder gsonBuilder){
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (jsonElement, type, jsonDeserializationContext) -> LocalDateTime.parse(jsonElement.getAsString(), DATE_TIME_FORMATTER));
    }

}
