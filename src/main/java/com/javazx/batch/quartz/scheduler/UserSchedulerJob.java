package com.javazx.batch.quartz.scheduler;
import com.javazx.batch.job.UserBatchJob;
import com.javazx.batch.quartz.ApplicationContextUtil;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author itmrchen
 * @date 2016/10/12
 * @time 13:19
 */
@DisallowConcurrentExecution
public class UserSchedulerJob extends QuartzJobBean{
	private static final Logger logger = LoggerFactory.getLogger(UserSchedulerJob.class);
	private String batchJob;
	
	public void setBatchJob(String batchJob){
		this.batchJob = batchJob;
	}
	
	@Override
	protected void executeInternal(JobExecutionContext context){
		logger.info("Quartz job started");
		ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
		UserBatchJob job = applicationContext.getBean(batchJob, UserBatchJob.class);
		logger.info("Quartz job started: "+ job);
		
		try{
			job.performJob();
		}catch(Exception exception){
			logger.error("Job "+ batchJob+" could not be executed : "+ exception.getMessage());
		}
		logger.info("Quartz job end");
	}
}