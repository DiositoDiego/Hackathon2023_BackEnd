package com.hackthon.conekta.conektaoxxo.model.charges;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ChargeReq {
    private Integer amount;
    private String paymentMethod;
    private String orderId;
}
