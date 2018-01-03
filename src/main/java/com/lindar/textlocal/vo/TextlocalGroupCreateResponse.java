package com.lindar.textlocal.vo;

import com.lindar.textlocal.TextlocalGroup;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class TextlocalGroupCreateResponse extends TextlocalResponse {
    private TextlocalGroup group;
}