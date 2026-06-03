package com.isabelle.crud.controller;

import com.isabelle.crud.entity.Customer;
import com.isabelle.crud.eligibility.EligibilityService;
import com.isabelle.crud.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eligibility")
public class EligibilityController {
    private final CustomerService customerService;
    private final EligibilityService eligibilityService;

    public EligibilityController(
            CustomerService customerService,
            EligibilityService eligibilityService) {

        this.customerService = customerService;
        this.eligibilityService = eligibilityService;
    }

    @GetMapping("/{document}")
    public boolean checkEligibility(
            @PathVariable String document) {

        Customer customer = customerService
                .getCustomerByDocument(document)
                .orElseThrow(() ->
                        new RuntimeException("Cliente não encontrado"));

        return eligibilityService.isEligible(customer);
    }
}