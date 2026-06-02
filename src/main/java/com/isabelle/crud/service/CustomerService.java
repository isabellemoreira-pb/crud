package com.isabelle.crud.service;

import com.isabelle.crud.entity.Customer;
import com.isabelle.crud.repository.CustomerRepository;
import com.isabelle.crud.exception.CustomerAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer){

        // Validação de cadastrado duplicado
        if (customerRepository.existsByDocument(customer.getDocument())){
            throw new CustomerAlreadyExistsException(
                    "Cliente já cadastrado com esse documento"
            );
        }

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id){
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        customer.setMcc(updatedCustomer.getMcc());
        customer.setAnnualTpv(updatedCustomer.getAnnualTpv());
        customer.setCustomerCompanyFlag(updatedCustomer.getCustomerCompanyFlag());

        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerByDocument(String document){
        return customerRepository.findByDocument(document);
    }

}

