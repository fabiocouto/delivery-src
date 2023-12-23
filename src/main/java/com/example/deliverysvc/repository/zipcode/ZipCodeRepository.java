package com.example.deliverysvc.repository.zipcode;

import com.example.deliverysvc.repository.clients.ZipCodeClient;
import com.example.deliverysvc.repository.clients.ZipCodeDto;
import org.springframework.stereotype.Repository;

@Repository
public class ZipCodeRepository {
    private final ZipCodeClient client;

    public ZipCodeRepository(ZipCodeClient client) {
        this.client = client;
    }

    public ZipCodeDto searchZipCode(String zipCodeNumber){
        return client.searchZipCode(zipCodeNumber);
    }
}
