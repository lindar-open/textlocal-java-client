package com.lindar.textlocal.vo;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class TextlocalMessageHistoryRequest {
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private TextlocalDirection sortDirection;
    private long start;
    private long limit;
}
