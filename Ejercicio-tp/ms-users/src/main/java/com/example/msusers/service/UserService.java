package com.example.msusers.service;

import com.example.msusers.domain.Bill;
import com.example.msusers.domain.User;
import com.example.msusers.domain.UserBills;
import com.example.msusers.repository.BillsRepository;
import com.example.msusers.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository repository;
    private final BillsRepository billsRepository;
    public UserBills findById(String id){
        User user = repository.findById(id);
        List<Bill> billList = billsRepository.findByCustomerBill(id);
        UserBills userBills = new UserBills();
        userBills.setUser(user);
        userBills.setBillList(billList);
        return userBills;
    }


}
