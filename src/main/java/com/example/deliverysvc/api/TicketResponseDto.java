package com.example.deliverysvc.api;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
public class TicketResponseDto {
    private Long id;
    private LocalDateTime dateTime;
    private BigDecimal price;
    private Integer orderId;
}
