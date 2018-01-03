package com.lindar.textlocal.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TextlocalBulkCreateContactsResponse extends TextlocalResponse {
    private long groupId;

    private int numContacts;
}