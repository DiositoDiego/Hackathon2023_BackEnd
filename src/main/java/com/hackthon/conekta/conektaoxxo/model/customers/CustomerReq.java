package com.hackthon.conekta.conektaoxxo.model.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerReq {
    private String name;
    private String email;
    private String phone;
}
