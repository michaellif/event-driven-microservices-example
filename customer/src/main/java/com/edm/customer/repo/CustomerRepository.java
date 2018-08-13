package com.edm.customer.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.edm.customer.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

	List<Customer> findByLastName(String lastName);
}
