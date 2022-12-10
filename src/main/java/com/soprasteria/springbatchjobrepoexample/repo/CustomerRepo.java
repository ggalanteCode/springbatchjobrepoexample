package com.soprasteria.springbatchjobrepoexample.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.springbatchjobrepoexample.entity.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer> {

}
