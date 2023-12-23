package com.example.deliverysvc.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketRequestDto {
    private String zipCode;
    private long orderId;
    private BigDecimal price;
}
