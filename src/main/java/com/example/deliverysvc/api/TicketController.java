package com.example.deliverysvc.api;

import com.example.deliverysvc.domain.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping("/v1/tickets")
    public ResponseEntity<List<TicketDto>> getTickets(){
        var tickets = service.getAll();
        return ResponseEntity.ok().body(null);
    }

    private TicketDto buildTicket() {
        TicketDto dto = new TicketDto();
        dto.setId(1L);
        dto.setDateTime(LocalDateTime.now());
        dto.setPrice(BigDecimal.TEN);
        return dto;
    }
}
