package main.java;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class SimpleJob implements Job {
	
	public SimpleJob() {
		
	}
	
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("Hello world! O processo: " + jobKey + " executando na hora " + new Date());
	}

}
