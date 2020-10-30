package br.com.contjamax.company.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HelloWorldBean {
    private String message;
}