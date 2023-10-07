package com.hackthon.conekta.conektaoxxo.controller.charges;

import com.hackthon.conekta.conektaoxxo.model.charges.ChargeReq;
import com.hackthon.conekta.conektaoxxo.service.charges.ChargeService;
import com.hackthon.conekta.conektaoxxo.utils.CustomResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-hack/charge")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor

public class ChargeController {

    private final ChargeService chargeApi;

    @PostMapping("/test")
    public ResponseEntity<CustomResponse> create (@RequestBody ChargeReq request) {
        try {
            return new ResponseEntity<>(
                    chargeApi.createCharge(request),
                    HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    chargeApi.createCharge(request),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
