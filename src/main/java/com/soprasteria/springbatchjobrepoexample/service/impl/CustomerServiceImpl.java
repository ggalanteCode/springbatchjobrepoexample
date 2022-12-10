package com.soprasteria.springbatchjobrepoexample.service.impl;

import org.springframework.stereotype.Service;

import com.soprasteria.springbatchjobrepoexample.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

//	@Override
//	public BatchStatus executeJob() throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
//		// TODO Auto-generated method stub
//		System.out.println("metodo del service");
//		JobParameters parameters = new JobParametersBuilder()
//                .addLong("startedAt", System.currentTimeMillis() + 10000).toJobParameters();
//		JobExecution execution = jobLauncher.run(job, parameters);
//		System.out.println("JOB EXECUTION STATUS: " + execution.getStatus());
//		
//		while(execution.isRunning()) {
//			System.out.println("THE BATCH IS RUNNING...");
//		}
//		
//		return execution.getStatus();
//	}

}
