package com.lindar.textlocal.vo;


import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
public class TextlocalResponse {
    private String status;
    private List<TextlocalMessageCode> errors = new ArrayList<>();
    private List<TextlocalMessageCode> warnings = new ArrayList<>();
}