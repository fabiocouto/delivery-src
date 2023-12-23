package com.example.deliverysvc.domain.zipcode;

import com.example.deliverysvc.repository.zipcode.ZipCodeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ZipCodeService {
    private final ZipCodeRepository repository;

    public ZipCodeService(ZipCodeRepository repository) {
        this.repository = repository;
    }

    public Optional<String> getStAddressName(String zipCodeNumber){
        return Optional.ofNullable(Optional.ofNullable(repository.searchZipCode(zipCodeNumber).getLogradouro())
                .orElseThrow(() -> new RuntimeException("Zipcode number not found")));
    }
}
