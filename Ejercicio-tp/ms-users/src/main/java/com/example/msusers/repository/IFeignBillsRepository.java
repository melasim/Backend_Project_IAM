package com.example.msusers.repository;

import com.example.msusers.configuration.feign.FeignInterceptor;
import com.example.msusers.domain.Bill;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name= "ms-bill",url = "http://localhost:8083", configuration = FeignInterceptor.class)
public interface IFeignBillsRepository {

    @GetMapping("bills/user")
    ResponseEntity<List<Bill>> findByCustomerBill(@RequestParam String userId);
}
