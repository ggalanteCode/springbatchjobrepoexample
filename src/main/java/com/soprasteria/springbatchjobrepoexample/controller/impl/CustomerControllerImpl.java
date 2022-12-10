package com.soprasteria.springbatchjobrepoexample.controller.impl;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.soprasteria.springbatchjobrepoexample.controller.CustomerController;

@RestController
@RequestMapping("/customers")
public class CustomerControllerImpl implements CustomerController {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;

	@Override
	@PostMapping(value = "/fromCSVToDB", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public BatchStatus fromCSVToDB(@RequestPart("file") MultipartFile file) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		// TODO Auto-generated method stub
		JobParameters parameters = new JobParametersBuilder()
                .addLong("startedAt", System.currentTimeMillis() + 10000)
                .addString("fileName", file.getOriginalFilename())
                .toJobParameters();
		JobExecution execution = jobLauncher.run(job, parameters);
		System.out.println("JOB EXECUTION STATUS: " + execution.getStatus());
		
		while(execution.isRunning()) {
			System.out.println("THE BATCH IS RUNNING...");
		}
		
		return execution.getStatus();
	}

}