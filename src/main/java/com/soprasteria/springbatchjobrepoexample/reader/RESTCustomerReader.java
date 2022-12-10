package com.soprasteria.springbatchjobrepoexample.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import com.soprasteria.springbatchjobrepoexample.dto.CustomerDTO;

public class RESTCustomerReader implements ItemReader<CustomerDTO> {
	
//	private final String apiUrl;
//    private final RestTemplate restTemplate;
// 
//    private int nextStudentIndex;
//    private List<CustomerDTO> studentData;

	@Override
	public CustomerDTO read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		// TODO Auto-generated method stub
		return null;
	}

}
