package com.lindar.textlocal.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TextlocalContactDeleteResponse extends TextlocalResponse {
    private long groupId;
    private String number;
}