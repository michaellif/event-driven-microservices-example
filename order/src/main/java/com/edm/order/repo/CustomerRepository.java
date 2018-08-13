package com.edm.order.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.edm.order.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

}
