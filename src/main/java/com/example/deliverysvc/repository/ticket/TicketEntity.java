package com.example.deliverysvc.repository.ticket;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "ticket")
public class TicketEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal price;
    private LocalDateTime dateTime;
    private String zipCode;
    private String streetAddress;
    private Long orderId;
}
