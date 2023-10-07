package com.hackthon.conekta.conektaoxxo.service.customers;

import com.conekta.ApiClient;
import com.conekta.ApiException;
import com.conekta.Configuration;
import com.conekta.CustomersApi;
import com.conekta.auth.HttpBearerAuth;
import com.conekta.model.Customer;
import com.conekta.model.CustomerResponse;

import com.hackthon.conekta.conektaoxxo.model.customers.CustomerReq;
import com.hackthon.conekta.conektaoxxo.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CustomerService {
    public CustomResponse<CustomerResponse> createCustomer (CustomerReq request) {

        ApiClient defaultClient = Configuration.getDefaultApiClient();

        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("key_nkUm2enRM6SEXt0zMBW1dUS");

        CustomersApi apiInstance = new CustomersApi(defaultClient);

        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        String acceptLanguage = "es";
        try {
            CustomerResponse result = apiInstance.createCustomer(customer, acceptLanguage, null);
            return new CustomResponse<>(
                    result, false,  200, "Succes to create customer!", "null"
            );
        } catch (ApiException e) {
            System.err.println("Exception when calling CustomersApi#createCustomer");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
            return new CustomResponse<>(null, true, e.getCode(), e.getResponseBody(), String.valueOf(e.getResponseHeaders()));
        }
    }
}
