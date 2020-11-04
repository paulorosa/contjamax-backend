package br.com.contjamax.company.domain;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(callSuper=true, includeFieldNames=true)
public class Company {
    @EqualsAndHashCode.Include 
    private long id;
    private String nickname;
    private String name;
    private String fantasyName;
    private String Address;
    private String inscricaoEstadual;
    private LocalDate activityStartDate;
    private LocalDate registrationDate;
    private Person responsible;
    private String PaymentScheme;
    private String cnae;
    private String legalNature;
    private String respresentative;
    private String activityDescription;
    private String ccm;

}