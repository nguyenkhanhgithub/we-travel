package com.example.wetravel.Constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {
    private int status;
    private Object data;
    private String message;
}
