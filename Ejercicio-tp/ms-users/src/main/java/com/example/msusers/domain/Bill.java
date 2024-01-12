package com.example.msusers.domain;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
@Data
public class Bill {
    private String idBill;
    private String customerBill;
    private String productBill;
    private Double totalPrice;
}
