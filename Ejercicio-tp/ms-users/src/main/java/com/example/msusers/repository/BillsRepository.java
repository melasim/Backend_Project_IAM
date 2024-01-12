package com.example.msusers.repository;

import com.example.msusers.domain.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillsRepository {

    private IFeignBillsRepository iFeignBillsRepository;

    public BillsRepository(IFeignBillsRepository iFeignBillsRepository) {
        this.iFeignBillsRepository = iFeignBillsRepository;
    }

    public List<Bill> findByCustomerBill (String CostumerBill){
        ResponseEntity<List<Bill>> response = iFeignBillsRepository.findByCustomerBill(CostumerBill);
        return response.getBody();
    }

}
