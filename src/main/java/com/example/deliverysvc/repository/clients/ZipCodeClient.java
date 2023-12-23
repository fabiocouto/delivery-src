package com.example.deliverysvc.repository.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ZipCodeClient {

    @GetMapping("/{zipCode}/json")
    ZipCodeDto searchZipCode(@PathVariable("zipCode") String zipCodeValue);
}
