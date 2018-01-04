package com.lindar.textlocal.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
public class TextlocalBatchStatusResponse extends TextlocalResponse {
    @SerializedName("batch_id")
    private long batchId;
    private List<TextlocalMessageStatus> messages = new ArrayList<>();

    @SerializedName("num_messages")
    private int numMessages;

    @SerializedName("num_delivered")
    private int numDelivered;

    @SerializedName("num_undelivered")
    private int numUndelivered;

    @SerializedName("num_unknown")
    private int numUnknown;

    @SerializedName("num_invalid")
    private int numInvalid;

}