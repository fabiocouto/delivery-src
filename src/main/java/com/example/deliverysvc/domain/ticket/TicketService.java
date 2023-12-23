package com.example.deliverysvc.domain.ticket;

import com.example.deliverysvc.domain.TicketConverter;
import com.example.deliverysvc.domain.zipcode.ZipCodeService;
import com.example.deliverysvc.repository.ticket.TicketEntity;
import com.example.deliverysvc.repository.ticket.TicketRespository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService {

    private final TicketRespository respository;
    private final ZipCodeService zipCodeService;
    private final TicketConverter converter;

    public TicketService(TicketRespository respository,
                         ZipCodeService zipCodeService,
                         TicketConverter converter) {
        this.respository = respository;
        this.zipCodeService = zipCodeService;
        this.converter = converter;
    }

    public Ticket getTicketById(Long id){
        var ticket = respository.findById(id);
        return buildTicket(ticket);
    }

    public List<Ticket> findAll(){
        return converter.toTickets(respository.findAll());
    }

    public Ticket createTicket(Ticket ticket) {

        var optZipCode = getStreetNameFromZipCode(ticket.getZipCode());
        if (optZipCode.isPresent()) {
            ticket.setStreetName(optZipCode.get());
        }
        var ticketEntity = converter.toTicketEntity(ticket);
        var response = respository.save(ticketEntity);
        return converter.toTicket(response);
    }

    private Optional<String> getStreetNameFromZipCode(String zipCode) {
        return zipCodeService.getStAddressName(zipCode);
    }

    private Ticket buildTicket(Optional<TicketEntity> optTicket) {
        if (optTicket.isPresent()){
            Ticket ticket = new Ticket();
            ticket.setId(optTicket.get().getId());
            ticket.setDateTime(optTicket.get().getDateTime());
            ticket.setPrice(optTicket.get().getPrice());
            ticket.setOrderId(optTicket.get().getOrderId());
            return ticket;
        }
        throw new RuntimeException("Ticket not founded!");
    }

    public void deleteTicket(long id) {
        respository.deleteById(id);
    }
}
