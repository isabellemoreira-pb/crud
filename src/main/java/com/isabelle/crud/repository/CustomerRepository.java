package com.isabelle.crud.repository;

import com.isabelle.crud.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByDocument(String document);
    // todo: outro findByDocument, com query nativa, vai retonar Customer
    // todo: omo parametro (documento, pf/pj), nome do metodo = buscaDocumentoPjPf

    //boolean existsByDocument(String document); // query method do Spring Data JPA (SELECT EXISTS(...))
}
