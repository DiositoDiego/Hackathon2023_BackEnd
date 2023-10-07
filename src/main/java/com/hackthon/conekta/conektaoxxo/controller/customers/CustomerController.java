package com.hackthon.conekta.conektaoxxo.controller.customers;

import com.hackthon.conekta.conektaoxxo.model.customers.CustomerReq;
import com.hackthon.conekta.conektaoxxo.service.customers.CustomerService;
import com.hackthon.conekta.conektaoxxo.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-hack/customer")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerApi;

    @PostMapping("/test")
    public ResponseEntity<CustomResponse> create (@RequestBody CustomerReq request) {
        try {
            return new ResponseEntity<>(
                    customerApi.createCustomer(request),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CustomResponse<>(null, true, 500, e.getMessage(), "null"),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}
