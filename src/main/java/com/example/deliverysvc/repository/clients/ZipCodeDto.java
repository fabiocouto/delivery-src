package com.example.deliverysvc.repository.clients;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZipCodeDto {
    private String logradouro;
    private String cep;
}
