package com.hackthon.conekta.conektaoxxo.controller.orders;

import com.conekta.model.OrderResponse;
import com.hackthon.conekta.conektaoxxo.model.orders.OrderReq;
import com.hackthon.conekta.conektaoxxo.service.orders.OrderService;
import com.hackthon.conekta.conektaoxxo.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-hack/order")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService orderApi;

    @PostMapping("/test")
    public ResponseEntity<CustomResponse<OrderResponse>> create (@RequestBody OrderReq request) {
        System.out.println("Prueba");
        try {
            return new ResponseEntity<>(
                    orderApi.createOrder(request),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new CustomResponse<>(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
