package com.example.deliverysvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRespository extends CrudRepository<TicketEntity, Long> {

}
