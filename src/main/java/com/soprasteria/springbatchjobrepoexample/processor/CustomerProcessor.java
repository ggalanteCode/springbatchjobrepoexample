package com.soprasteria.springbatchjobrepoexample.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.soprasteria.springbatchjobrepoexample.entity.Customer;

@Component
public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

	@Override
	public Customer process(Customer item) throws Exception {
		// TODO Auto-generated method stub
		return item;
	}

}
