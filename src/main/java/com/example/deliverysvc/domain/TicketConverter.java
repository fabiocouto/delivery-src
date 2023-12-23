package com.example.deliverysvc.domain;

import com.example.deliverysvc.api.TicketRequestDto;
import com.example.deliverysvc.api.TicketResponseDto;
import com.example.deliverysvc.domain.ticket.Ticket;
import com.example.deliverysvc.repository.ticket.TicketEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketConverter {
    public TicketResponseDto toTicketResponseDto(Ticket ticket) {
        TicketResponseDto responseDto = new TicketResponseDto();
        responseDto.setPrice(ticket.getPrice());
        responseDto.setDateTime(ticket.getDateTime());
        responseDto.setId(ticket.getId());
        responseDto.setOrderId(ticket.getOrderId().intValue());
        return responseDto;
    }

    public Ticket toTicket(TicketRequestDto requestDto) {
        Ticket ticket  = new Ticket();
        ticket.setPrice(requestDto.getPrice());
        ticket.setZipCode(requestDto.getZipCode());
        ticket.setDateTime(LocalDateTime.now());
        ticket.setOrderId(requestDto.getOrderId());
        return ticket;
    }

    public Ticket toTicket(TicketEntity entity) {
        Ticket ticket = new Ticket();
        ticket.setId(entity.getId());
        ticket.setPrice(entity.getPrice());
        ticket.setOrderId(entity.getOrderId());
        ticket.setDateTime(entity.getDateTime());
        ticket.setStreetName(entity.getStreetAddress());
        return ticket;
    }


    public TicketEntity toTicketEntity(Ticket ticket) {
        TicketEntity entity = new TicketEntity();
        entity.setZipCode(String.valueOf(ticket.getZipCode()));
        entity.setOrderId(ticket.getOrderId());
        entity.setPrice(ticket.getPrice());
        entity.setDateTime(ticket.getDateTime());
        entity.setStreetAddress(ticket.getStreetName());
        return entity;
    }

    public List<Ticket> toTickets(List<TicketEntity> all) {
        return all.stream().map(this::toTicket).collect(Collectors.toList());
    }

    public List<TicketResponseDto> toTicketsDtoResponse(List<Ticket> tickets) {
        return tickets.stream().map(this::toTicketResponseDto).collect(Collectors.toList());
    }
}
