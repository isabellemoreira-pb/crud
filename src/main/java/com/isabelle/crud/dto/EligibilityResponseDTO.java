package com.isabelle.crud.dto;

public class EligibilityResponseDTO {

    private String document;
    private boolean eligible;
    private String reason;

    public EligibilityResponseDTO() {
    }

    public EligibilityResponseDTO(String document,
                                  boolean eligible,
                                  String reason) {
        this.document = document;
        this.eligible = eligible;
        this.reason = reason;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public boolean isEligible() {
        return eligible;
    }

    public void setEligible(boolean eligible) {
        this.eligible = eligible;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}