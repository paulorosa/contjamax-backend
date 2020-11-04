package br.com.contjamax.company.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {
    private String name;
    private String cpf;
    private String qualification;
    private String phone;
}