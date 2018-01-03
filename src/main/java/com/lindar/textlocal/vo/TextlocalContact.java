package com.lindar.textlocal.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(of = "number")
public class TextlocalContact {
    private String number;
    private String firstName;
    private String lastName;
    private String custom1;
    private String custom2;
    private String custom3;
}
