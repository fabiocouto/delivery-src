package com.example.deliverysvc.domain.ticket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ticket {

    private Long id;
    private BigDecimal price;
    private LocalDateTime dateTime;
    private Long orderId;
    private String streetName;
    private String zipCode;
}
