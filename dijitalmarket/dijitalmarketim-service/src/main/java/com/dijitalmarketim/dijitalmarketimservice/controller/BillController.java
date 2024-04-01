package com.dijitalmarketim.dijitalmarketimservice.controller;

import com.dijitalmarketim.dijitalmarketimservice.dto.request.BillRequest;
import com.dijitalmarketim.dijitalmarketimservice.model.Bill;
import com.dijitalmarketim.dijitalmarketimservice.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.dijitalmarketim.dijitalmarketimservice.service.IBillService;

@RestController
@RequestMapping("api/bills")
@RequiredArgsConstructor
public class BillController {

    private final IBillService billService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Bill> createBill(@RequestBody BillRequest request) {
    
        return ResponseEntity.ok().body(billService.createBill(request));
    }

}
