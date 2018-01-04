package com.lindar.textlocal.vo;

import com.lindar.textlocal.TextlocalGroup;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
public class TextlocalGroupMessageHistoryResponse extends TextlocalResponse {
    private List<TextlocalMessage> messages = new ArrayList<>();
    private int start;
    private int limit;
    private int total;
}