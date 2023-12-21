package com.example.deliverysvc.domain;

import com.example.deliverysvc.repository.TicketEntity;
import com.example.deliverysvc.repository.TicketRespository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TicketService {

    private final TicketRespository respository;

    public TicketService(TicketRespository respository) {
        this.respository = respository;
    }

    public Ticket getTicketById(Long id){
        var ticket = respository.findById(id);
        return buildTicket(ticket);
    }

    private Ticket buildTicket(Optional<TicketEntity> optTicket) {
        if (optTicket.isPresent()){
            Ticket ticket = new Ticket();
            ticket.setId(optTicket.get().getId());
            ticket.setDateTime(optTicket.get().getDateTime());
            ticket.setPrice(optTicket.get().getPrice());
            return ticket;
        }
        throw new RuntimeException("Ticket not founded!");
    }

    private Ticket toTicket(TicketEntity entity) {
            Ticket ticket = new Ticket();
            ticket.setId(entity.getId());
            ticket.setPrice(entity.getPrice());
            ticket.setDateTime(entity.getDateTime());
            return ticket;

    }

    public List<Ticket> getAll() {

        Iterator<Ticket> it = Arrays.asList((Ticket) respository.findAll()).iterator();
        List<Ticket> list = new ArrayList<>();
        while (it.hasNext()){
            list.add(it.next());
        }
        return list;
    }

    private List<Ticket> toTickets(Iterable<TicketEntity> all) {
        var tickets = all;
        return null;
    }
}
