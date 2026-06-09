package com.isabelle.crud.service;

import com.isabelle.crud.entity.Customer;
import com.isabelle.crud.repository.CustomerRepository;
import com.isabelle.crud.exception.CustomerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

// O @Autowired foi inserido no lugar de:

//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public Customer createCustomer(Customer customer){

        // Validação de cadastrado duplicado
//        if (customerRepository.existsByDocument(customer.getDocument())){
//            throw new CustomerAlreadyExistsException(
//                    "Cliente já cadastrado com esse documento"
//            );
//        }

        //todo: substituir o bloco comentado acima por um  if/else com try/catch

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

    //todo: Fazer um delete by document (só se o ducumento for válido e se for pessoa fisica)
    // ( se for PJ lançar EX personalizada)

    public Customer updateCustomer(Long id, Customer updatedCustomer) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

            customer.setMcc(updatedCustomer.getMcc());
            customer.setAnnualTpv(updatedCustomer.getAnnualTpv());
            customer.setCustomerCompanyFlag(updatedCustomer.getCustomerCompanyFlag());

            return customerRepository.save(customer);

//    try {
//        Optional<Customer> optionalCustomer = customerRepository.findById(id);
//        System.out.println(optionalCustomer);
//
//        boolean encontrouCustomer = optionalCustomer.isPresent();
//        System.out.println(encontrouCustomer);
//
//        if (encontrouCustomer) {
//            Customer customer = optionalCustomer.get();
//            System.out.println(customer);
//
//            customer.setMcc(updatedCustomer.getMcc());
//            customer.setAnnualTpv(updatedCustomer.getAnnualTpv());
//            customer.setCustomerCompanyFlag(updatedCustomer.getCustomerCompanyFlag());
//
//            System.out.println(customer);
//            return customerRepository.save(customer);
//        } else {
//            throw new IllegalArgumentException("Cliente não encontrado");
//        }
//    } catch (Exception ex){
//        System.out.println("Entrou no bloco catch");
//        return null;
//    }
//    finally {
//        System.out.println("Alarme de update");
//    }
    }

    public Optional<Customer> getCustomerByDocument(String document){
        return customerRepository.findByDocument(document);
    }

}

