package com.hackthon.conekta.conektaoxxo.service.charges;

import com.conekta.ApiClient;
import com.conekta.ApiException;
import com.conekta.ChargesApi;
import com.conekta.Configuration;
import com.conekta.auth.HttpBearerAuth;
import com.conekta.model.*;
import com.hackthon.conekta.conektaoxxo.model.charges.ChargeReq;
import com.hackthon.conekta.conektaoxxo.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class ChargeService {
    public CustomResponse<ChargeOrderResponse> createCharge (ChargeReq request){
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("key_nkUm2enRM6SEXt0zMBW1dUS");

        ChargesApi apiInstance = new ChargesApi(defaultClient);
        ChargeRequest chargeRequest = new ChargeRequest();
        chargeRequest.setAmount((request.getAmount()) * 100);
        ChargeRequestPaymentMethod chargeRequestPaymentMethod = new ChargeRequestPaymentMethod();
        chargeRequestPaymentMethod.setType(request.getPaymentMethod());
        chargeRequest.setPaymentMethod(chargeRequestPaymentMethod);
        String accepLanguage = "es";
        try {
            ChargeOrderResponse result = apiInstance.ordersCreateCharge(request.getOrderId(), chargeRequest, accepLanguage, null);
            return new CustomResponse<>(result, false, 200, "Succes to create charge", "null"
            );
        } catch (ApiException e) {
            System.err.println("Exception when calling ChargerApi#createCharge");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response header: " + e.getResponseHeaders());
            e.getStackTrace();
            return new CustomResponse<>(null, true, e.getCode(), e.getResponseBody(), String.valueOf(e.getResponseHeaders()));
        }
    }
}
