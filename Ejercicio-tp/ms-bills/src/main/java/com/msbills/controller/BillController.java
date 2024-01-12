package com.msbills.controller;

import com.msbills.models.Bill;
import com.msbills.service.BillService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillController {

    private final BillService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<Bill>> getAll() {
        return ResponseEntity.ok().body(service.getAllBill());
    }

    @GetMapping("/user")
    public ResponseEntity<List<Bill>> findByCustomerBill (@RequestParam String userId) {
        return ResponseEntity.ok().body(service.getBillsByUserId(userId));
    }

    @PostMapping("/crear")
    @PreAuthorize("hasAuthority('GROUP_/PROVIDERS')")
    public ResponseEntity crearFactura (@RequestBody Bill bill){
        return ResponseEntity.ok(service.crearFactura(bill));
    }
}
