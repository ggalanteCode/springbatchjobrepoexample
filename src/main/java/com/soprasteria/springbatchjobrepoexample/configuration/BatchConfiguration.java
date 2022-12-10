package com.soprasteria.springbatchjobrepoexample.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

import com.soprasteria.springbatchjobrepoexample.entity.Customer;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Bean
	@StepScope
	public FlatFileItemReader<Customer> txtFileCustomerReader(@Value("#{jobParameters['fileName']}") String fileLocation) {
		FlatFileItemReader<Customer> flatFileItemReader = new FlatFileItemReader<>();
	    flatFileItemReader.setResource(new FileSystemResource(fileLocation));
	    flatFileItemReader.setName("CSV-Reader");
	    flatFileItemReader.setLineMapper(lineMapper());
	    return flatFileItemReader;
	}
	
	@Bean
	public LineMapper<Customer> lineMapper() {
        DefaultLineMapper<Customer> lineMapper = new DefaultLineMapper<Customer>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("codiceCliente", "nome", "cognome", "indirizzo", "email", "telefono");

        BeanWrapperFieldSetMapper<Customer> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Customer.class);
        
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;

    }
	
	@Bean
	@Qualifier("job")
	public Job job(JobBuilderFactory jobBuilderFactory,
				   StepBuilderFactory stepBuilderFactory,
				   ItemReader<Customer> reader,
				   ItemProcessor<Customer, Customer> processor,
				   ItemWriter<Customer> writer) {
		Step step = stepBuilderFactory.get("customersStep").<Customer, Customer>chunk(100)
				.reader(reader)
				.processor(processor)
				.writer(writer)
				.build();
		
		return jobBuilderFactory.get("importCustomers")
	                .start(step)
	                .build();
	}

}
