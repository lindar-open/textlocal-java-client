package com.lindar.textlocal.vo;

import com.lindar.textlocal.TextlocalGroup;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
public class TextlocalGroupListResponse extends TextlocalResponse {
    private List<TextlocalGroup> groups = new ArrayList<>();
    private int numGroups;
}