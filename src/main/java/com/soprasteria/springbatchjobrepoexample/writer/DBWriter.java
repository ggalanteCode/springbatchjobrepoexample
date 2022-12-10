package com.soprasteria.springbatchjobrepoexample.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soprasteria.springbatchjobrepoexample.entity.Customer;
import com.soprasteria.springbatchjobrepoexample.repo.CustomerRepo;

@Component
public class DBWriter implements ItemWriter<Customer> {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public void write(List<? extends Customer> items) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("saveAll " + items);
		customerRepo.saveAll(items);
	}

	
	
}
