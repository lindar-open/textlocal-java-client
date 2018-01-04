package com.lindar.textlocal.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TextlocalMessage {
    @SerializedName("batch_id")
    private long batchId;
    @SerializedName("group_id")
    private long groupId;
    @SerializedName("group_name")
    private String groupName;
    private String message;
    @SerializedName("datetime")
    private LocalDateTime date;
    @SerializedName("num_credits")
    private int numCredits;
}
