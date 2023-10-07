package com.hackthon.conekta.conektaoxxo.service.orders;

import com.conekta.ApiClient;
import com.conekta.ApiException;
import com.conekta.Configuration;
import com.conekta.OrdersApi;
import com.conekta.auth.HttpBearerAuth;
import com.conekta.model.*;
import com.hackthon.conekta.conektaoxxo.model.orders.OrderReq;
import com.hackthon.conekta.conektaoxxo.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor

public class OrderService {
    public CustomResponse<OrderResponse> createOrder (OrderReq request){
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.conekta.io");


        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("key_nkUm2enRM6SEXt0zMBW1dUS");


        OrdersApi apiInstance = new OrdersApi(defaultClient);


        CheckoutRequest checkoutRequest = new CheckoutRequest();
        checkoutRequest.setAllowedPaymentMethods(Arrays.asList(request.getPaymentMethod()));


        OrderRequestCustomerInfo customerInfo = new OrderRequestCustomerInfo(new CustomerInfoJustCustomerId().customerId(request.getCustomerId()));

        List<Product> updatedProductsList = request.getProductsList().stream().map(product -> {
            product.setUnitPrice(product.getUnitPrice() * 100);
            return product;
        }).toList();

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setCurrency("MXN");
        orderRequest.setCheckout(checkoutRequest);
        orderRequest.setCustomerInfo(customerInfo);
        orderRequest.setLineItems(updatedProductsList);

        orderRequest.setLineItems(request.getProductsList());
        String acceptLanguage = "es";
        try {
            OrderResponse result = apiInstance.createOrder(orderRequest, acceptLanguage,null);
            return new CustomResponse<>(
                    result, false, 200, "Succes to create order!", "null"
            );
        } catch (ApiException e) {
            System.err.println("Exception when calling OrdersApi#createOrder");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return new CustomResponse<>(null, true, e.getCode(), e.getResponseBody(), String.valueOf(e.getResponseHeaders()));
        }
    }
}