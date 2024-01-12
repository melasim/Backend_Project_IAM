package com.example.msusers.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBills {
    private User user;
    private List<Bill> billList;
}
