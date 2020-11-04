package br.com.contjamax.company.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
    private String type;
    private String name;
    private String complement;
    private String district;
    private String zipCode;
    private String city;
    private String state;
}