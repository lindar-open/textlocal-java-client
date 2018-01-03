package com.lindar.textlocal.vo;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(of = "number")
public class TextlocalContact {
    private String number;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    private String custom1;
    private String custom2;
    private String custom3;
}
