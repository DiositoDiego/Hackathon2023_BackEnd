package com.hackthon.conekta.conektaoxxo.model.orders;

import com.conekta.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderReq {
    private String paymentMethod;
    private String customerId;
    private List<Product> productsList;
}
