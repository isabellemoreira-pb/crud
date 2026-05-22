package com.isabelle.crud.entity;

import jakarta.persistence.*;
import java.math.BigDecimal; // mais seguro do que double pra valor monetário

@Entity // essa classe representa uma tabela do banco
@Table(name = "custumers") // define o nome da tabela
public class Custumer {

    @Id // define a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // faz o banco gerar id automaticamente
    private Long id;

    private String document;

    private String indicationDocumentType;

    private Boolean custumerComapanyFlag;

    private String mcc;

    private BigDecimal annualTpv;

    public Custumer(){

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

    public Boolean getCustumerComapanyFlag() {
        return custumerComapanyFlag;
    }

    public void setCustumerComapanyFlag(Boolean custumerComapanyFlag) {
        this.custumerComapanyFlag = custumerComapanyFlag;
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
}
