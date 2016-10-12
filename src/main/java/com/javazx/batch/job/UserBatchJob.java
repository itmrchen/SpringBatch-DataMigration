package com.javazx.batch.job;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;

/**
 * @author itmrchen
 * @date 2016/10/12
 * @time 13:19
 */
public class UserBatchJob {
	private String jobName;

	private JobLocator jobLocator;

	private JobLauncher jobLauncher;

	public void performJob() {

		try {
			JobExecution result = jobLauncher.run(jobLocator.getJob(jobName),
					new JobParametersBuilder().toJobParameters());
		} catch (JobExecutionException ex) {
		}
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public void setJobLocator(JobLocator jobLocator) {
		this.jobLocator = jobLocator;
	}

	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

}
