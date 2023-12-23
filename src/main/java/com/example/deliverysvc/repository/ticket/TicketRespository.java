package com.example.deliverysvc.repository.ticket;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRespository extends CrudRepository<TicketEntity, Long> {
    List<TicketEntity> findAll();
    Optional<TicketEntity> findById(Long id);

}
