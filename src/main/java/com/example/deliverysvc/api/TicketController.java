package com.example.deliverysvc.api;

import com.example.deliverysvc.domain.TicketConverter;
import com.example.deliverysvc.domain.ticket.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketController {

    private final TicketService service;
    private final TicketConverter converter;

    public TicketController(TicketService service, TicketConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @GetMapping("/v1/tickets")
    public ResponseEntity<List<TicketResponseDto>> getTickets(){
        var tickets = service.findAll();
        return ResponseEntity.ok().body(converter.toTicketsDtoResponse(tickets));
    }

    @GetMapping("/v1/tickets/{id}")
    public ResponseEntity<TicketResponseDto> getTicketById(@PathVariable(name = "id", required = true) long id){
        var ticket = service.getTicketById(id);
        return ResponseEntity.ok().body(converter.toTicketResponseDto(ticket));
    }

    @DeleteMapping("/v1/tickets/{id}")
    public ResponseEntity<Void> deleteTicketById(@PathVariable(name = "id", required = true) long id){
        service.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/v1/tickets")
    public ResponseEntity<TicketResponseDto> createTicket(@RequestBody TicketRequestDto requestDto){
        var response = converter
                .toTicketResponseDto(service.createTicket(converter.toTicket(requestDto)));
        return ResponseEntity.created(URI.create("/v1/tickets"))
                .body(response);
    }
}
