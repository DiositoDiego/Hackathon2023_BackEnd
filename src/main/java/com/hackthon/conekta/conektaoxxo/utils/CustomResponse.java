package com.hackthon.conekta.conektaoxxo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CustomResponse<T> {
    T data;

    boolean error;

    int statusCode;

    String message;

    String header;
}
