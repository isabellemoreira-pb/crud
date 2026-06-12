package com.isabelle.crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal; // mais seguro do que double pra valor monetário

@Entity // essa classe representa uma tabela do banco
@Table(name = "customers") // define o nome da tabela
public class Customer {

    @Id // define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // faz o banco gerar id automaticamente
    private Long id;

    @NotBlank
    private String document;

    @NotBlank
    private String indicationDocumentType;

    private Boolean customerCompanyFlag;

    @NotBlank
    private String mcc;

    @NotNull
    @PositiveOrZero
    private BigDecimal annualTpv;

    public Customer(){

    }

    public Long getId() {
        return id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getIndicationDocumentType() {
        return indicationDocumentType;
    }

    public void setIndicationDocumentType(String indicationDocumentType) {
        this.indicationDocumentType = indicationDocumentType;
    }

    public Boolean getCustomerCompanyFlag() {
        return customerCompanyFlag;
    }

    public void setCustomerCompanyFlag(Boolean customerCompanyFlag) {
        this.customerCompanyFlag = customerCompanyFlag;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public BigDecimal getAnnualTpv() {
        return annualTpv;
    }

    public void setAnnualTpv(BigDecimal annualTpv) {
        this.annualTpv = annualTpv;
    }

    @Override
        public String toString() {
            return "Customer{" +
                "id=" + id +
                ", document='" + document + '\'' +
                ", indicationDocumentType='" + indicationDocumentType + '\'' +
                ", customerCompanyFlag=" + customerCompanyFlag +
                ", mcc='" + mcc + '\'' +
                ", annualTpv=" + annualTpv +
                '}';
    }
}
